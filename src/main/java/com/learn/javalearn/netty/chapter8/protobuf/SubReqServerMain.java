package netty.chapter8.protobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * Created by Administrator on 2017/3/20.
 * DelimiterBasedFrameDecoder以分隔符作为码流结束标识的消息的编码
 */
public class SubReqServerMain {
    public void bind(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
             ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100).handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ByteBuf delimiter= Unpooled.copiedBuffer("$_".getBytes());
                    socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter)) ;
                    socketChannel.pipeline().addLast(new StringDecoder());
                    socketChannel.pipeline().addLast(new EchoServerHandler());
                }
            });
            //绑定接口，同步等待成功
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

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (null != args && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        new SubReqServerMain().bind(port);
    }
}
