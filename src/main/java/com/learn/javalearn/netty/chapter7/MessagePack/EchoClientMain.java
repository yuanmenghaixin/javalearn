package netty.chapter7.MessagePack;

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
public class EchoClientMain {
    private final String host;
    private final int port;
    private final int sendNumber;
    public EchoClientMain(String host,int port,int sendNumber){
        this.host=host;
        this.port=port;
        this.sendNumber = sendNumber;
    }

    public void run() throws Exception {
        //配置客戶端NIO線程組
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                   ;
                    //DelimiterBasedFrameDecoder 解码器
                    socketChannel.pipeline().addLast("msgpack decoder",new MsgpackDecoder());
                    //StringDecoder解码器
                    socketChannel.pipeline().addLast("msgpack encoder",new MsgpackEncoder());
                    socketChannel.pipeline().addLast(new EchoClientHandler(sendNumber));
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
        new EchoClientMain("127.0.0.1",port,8).run();
    }


}
