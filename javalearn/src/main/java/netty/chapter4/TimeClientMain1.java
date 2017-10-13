package netty.chapter4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * Created by Administrator on 2017/3/21.
 *
 * 客户端应该收到100当前系统时间的消息，但实际上只收到一条。因为服务端只收到两次请求消息，所以服务只发送了两条应答，由于请求消息
 * 不满足查询条件，所以返回了2条“BAD ORDER”执行的消息，说明服务端返回的应答消息也发生粘包了
 */
public class TimeClientMain1 {
    public void connect(int port, String host) throws Exception {
        //配置客戶端NIO線程組
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new TimeClientHandler1());
                }
            });
            //发起异步连接操作
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            //等待客户端链路关闭
            channelFuture.channel().closeFuture().sync();
        }finally{
            //优雅的退出，释放NIO数组
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (null != args && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        new TimeClientMain1().connect(port,"127.0.0.1");
    }


}
