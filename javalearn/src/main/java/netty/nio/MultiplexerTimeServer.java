package netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/14.
 */
public class MultiplexerTimeServer implements Runnable{
    /**
     * 多路复用器Selector
     */
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean stop;
    /**
     * 初始化多路复用器，绑定监听端口
     */
    public MultiplexerTimeServer(int port){
        try {
            //打开ServerSocketChannel，用于舰艇客户端的连接，他是所有客户端的连接父管道
            serverSocketChannel=ServerSocketChannel.open();
            //设置连接为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //第二步绑定舰艇端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            //第三步：创建多路复用器
            selector = Selector.open();
            //第四步：将serverSocketChannel注册到多路复用器selector上，监听ACCEPT)事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port:"+port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop=true;
    }

    public void run() {
        //第五步：多路复用器在线程run()方法的无限循环体内轮训准备就绪的Key
        while(!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                Iterator<SelectionKey> it=selectionKeys.iterator();
                SelectionKey key =null;
                while (it.hasNext()){
                    key=it.next();
                    it.remove();
                    handleInput(key);
                }
               /* if(key!=null){
                    key.cancel();
                    if(key.channel()!=null){
                        key.channel().close();
                    }
                }
                //
                if(selector!=null){
                    selector.close();
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key){
        if(key.isValid()){
            //处理新接入的消息
            if(key.isAcceptable()){
                //接受一个新的连接
                ServerSocketChannel serverSocketChannel= (ServerSocketChannel) key.channel();
                SocketChannel socketChannel= null;
                try {
                    //第六步：多路复用器监听到有新的客户端接入，处理新的接入请求，完成TCP的三次握手，建立物理连接
                    socketChannel = serverSocketChannel.accept();
                    //第七步：设置客户端链路为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // Add a new connection to the selector;
                    //第八步：将新接入的客户端连接注册到多路复用器上，监听读操作，读取客户端发送的网络消息
                    socketChannel.register(selector,SelectionKey.OP_CONNECT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(key.isReadable()){
                // Read the data;
                SocketChannel socketChannel= (SocketChannel) key.channel();
                ByteBuffer readBuffer= ByteBuffer.allocate(1024);
                try {
                    //第九步：异步读取客户端请求消息到缓冲区
                    int readBytes=socketChannel.read(readBuffer);
                    if(readBytes>0){
                        readBuffer.flip();
                        byte[] bytes= new byte[readBuffer.remaining()];
                        readBuffer.get(bytes);
                        String body=new String(bytes,"UTF-8");
                        System.out.println("The time server receive order:"+body);
                        String currentTime="QUERY TIME ORDER".equalsIgnoreCase(body)?new java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
                        doWrite(socketChannel,currentTime);
                    }else if(readBytes<0){
                        //对端链路关闭
                        key.cancel();
                        socketChannel.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doWrite(SocketChannel channel,String response){
        if(response!=null && response.trim().length()>0){
            byte[] bytes=response.getBytes();
            ByteBuffer writeBuffer= ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            try {
                //第十一步：调用SocketChannel的异步write接口，将消息异步发送给客户端
                channel.write(writeBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }}
