package netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2017/3/16.
 * 时间服务器客户端
 */
public class TimeClientHandle implements Runnable{
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;
    public TimeClientHandle(String host,int port){
        this.host=host==null?"127.0.0.1":host;
        this.port=port;
        try {
            selector=Selector.open();
            socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() {
    doConnect();
    }
    private void doConnect(){
        //如果直接连接成功，则注册到多路复用器上，发送请求消息，读应答
        try {
            if(socketChannel.connect(new InetSocketAddress(host,port))){
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel);
            }else{
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void doWrite(SocketChannel socketChannel){
        byte[] req ="QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        try {
            socketChannel.write(writeBuffer);
            if(!writeBuffer.hasRemaining()){
                System.out.println("Send order 2 server succeed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
