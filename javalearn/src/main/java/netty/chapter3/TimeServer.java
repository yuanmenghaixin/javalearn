package netty.chapter3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.traffic.ChannelTrafficShapingHandler;


/**
 * Created by Administrator on 2017/3/20.
 */
public class TimeServer {
    public void bind(int port) throws Exception {
        //创建了两个NioEventLoopGroup实例，NioEventLoopGroup是个线程组，它包含了一组NIO线程，专门用于网络事件的处理，实际上
        //它们是reactor线程组.这里创建两个的原因是一个用于服务端接受客户端的连接，另一个用于进行SocketChannel的网络读写。
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建ServerBootstrap对象，他是Netty用于启动NIO服务端的补助启动类，目的为了降低服务端的复杂度。
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            //调用serverBootstrap的group方法，将两个NIO线程组当作入参传递到ServerBootstrap中。接着设置创建Channel为NioServerSocketChannel，
            //它的功能对应于JDK NIO类库中的ServerSocketChannel类。然后配置NioServerSocketChannel的TCP参数，此处将它的backlog设置为1024，
            //最后绑定I/O事件的处理类ChildChannelHandler，它的作用类似于reactor模式中的handler类，主要用于处理网络I/O事件
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChildChannelHandler());
            //bind方法绑定接口，随后，调用它的同步阻塞方法sync()等待绑定操作完成。完成之后返回一个ChannelFuture,
            //它的功能类似于JDK的java.util.concurrent.Future，主要用于异步操作的通知回调。
            ChannelFuture f = serverBootstrap.bind(port).sync();
            //等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (null != args && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        new TimeServer().bind(port);
    }
}
