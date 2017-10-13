package netty.chapter8.protobuf;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;


/**
 * Created by Administrator on 2017/3/21.
 */
public class EchoClientHandler extends ChannelHandlerAdapter{
    private static final Logger logger=Logger.getLogger(EchoClientHandler.class.getName());
    private int counter;
    private byte[] req;
    static final String ECHO_REQ="Hi,Lilinfen.Welcome to Netty.$_";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i=0;i<10;i++){
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //buf.readBytes(req);
        String body= (String) msg;
        System.out.println("This is counter :"+  ++counter+"times receive server:"+body+";");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        logger.warning("Unexpected exception from downstream:"+cause.getMessage());
        ctx.close();
    }
}
