package netty.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/3/17.
 */
public class AsyncTimeServerHandler implements Runnable {
    private int port;
    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;//异步的服务端通道

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            //首先创建一个异步的服务端AsynchronousServerSocketChannel，然后调用它的bind方法绑定监听端口。如果端口合法且没被占用，
            //则绑定成功，打印启动成功提示到控制台
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port:" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        //初始化CountDownLatch对象，它的作用是在完成一组正在执行的操作之前，允许当前的线程一直阻塞。在本例程中，我们让线程在此阻塞，防止服务端执行完成退出，
        //在实际项目应用中，不需要启动独立的线程来AsynchronousServerSocketChannel
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doAccept() {
        //用户接收客户端的连接，由于是异步操作，我们可以传递一个CompletionHandler<AsynchronousSocketChannel,?super A>类型的handler实例接收accept操作成功的通知消息
        //在本例程中我们通过AcceptCompletionHandler实例作为handler来接收通知消息
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }
}
