package netty.chapter3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;


/**
 * Created by Administrator on 2017/3/21.
 */
public class TimeClientHandler extends ChannelHandlerAdapter{
    private static final Logger logger=Logger.getLogger(TimeClientHandler.class.getName());
    private final ByteBuf firstMessage;

    public TimeClientHandler(){
        byte[] req="QUERY TIME ORDER".getBytes();
        firstMessage= Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        //调用channelActive方法，发送查询时间的指令给服务端，调用ChannelHandlerContext的writeAndFlush方法将请求消息发送给服务端
        ctx.writeAndFlush(firstMessage);
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //当服务端返回应答消息时，channelRead方法被调用
        ByteBuf buf=(ByteBuf)msg;
        byte[] req=new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("Now is:"+body);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        logger.warning("Unexpected exception from downstream:"+cause.getMessage());
        ctx.close();
    }
}
