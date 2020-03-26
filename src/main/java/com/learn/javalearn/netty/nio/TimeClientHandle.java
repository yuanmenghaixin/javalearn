package netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/16.
 * 时间服务器客户端
 */
public class TimeClientHandle implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            selector = Selector.open();
            //第一步：打开SocketChannel，绑定客户端本地地址
            socketChannel = SocketChannel.open();
            //第二部：设置SocketChannel为非阻塞模式,同时设置客户端连接的TCP参数
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        doConnect();
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        handleInput(selectionKey);
                    } catch (Exception e) {
                        if (selectionKey != null) {
                            selectionKey.channel();
                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        if(selector!=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            //判断是否连接成功
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            if (selectionKey.isConnectable()) {
                if (socketChannel.finishConnect()) {
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    doWrite(socketChannel);
                } else {
                    System.exit(1);//连接失败，进退退出
                }
                if (selectionKey.isReadable()) {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int readBytes = socketChannel.read(readBuffer);
                    if (readBytes > 0) {
                        readBuffer.flip();
                        byte[] bytes = new byte[readBuffer.remaining()];
                        String body = new String(bytes, "UTF-8");
                        System.out.println("Now is:" + body);
                        this.stop = true;
                    } else if (readBytes < 0) {
                        //对端链路关闭
                        selectionKey.cancel();
                        socketChannel.close();
                    } else {
                        ;//读到0字节，忽略
                    }
                }
            }
        }
    }



    private void doConnect() {
        //如果直接连接成功，则注册到多路复用器上，发送请求消息，读应答
        try {
            //第三步：异步连接服务端，第四步判断是否成功，如果连接成功，则直接注册读状态位到多路复用器中，如果当前没有
            //连接成功（异步连接，返回false，说明客户端已经发送sync包，服务端没有返回ack包，物理链路还没有建立）
            if (socketChannel.connect(new InetSocketAddress(host, port))) {
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel);
            } else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void doWrite(SocketChannel socketChannel) {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        try {
            socketChannel.write(writeBuffer);
            if (!writeBuffer.hasRemaining()) {
                System.out.println("Send order 2 server succeed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
