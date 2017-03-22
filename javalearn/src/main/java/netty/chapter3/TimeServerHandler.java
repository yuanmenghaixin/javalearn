package netty.chapter3;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;


/**
 * Created by Administrator on 2017/3/21.
 */
public class TimeServerHandler extends ChannelHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext,Object msg){
        ByteBuf buf=(ByteBuf) msg;
        byte[] req =new byte[buf.readableBytes()];
        buf.readBytes(req);
        try {
            String body=new String(req,"UTF-8");
            System.out.println("The time server receive order:"+body);
            String currentTime="QUERY TIME ORDER".equalsIgnoreCase(body)?new java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
            ByteBuf resq= Unpooled.copiedBuffer(currentTime.getBytes());
            channelHandlerContext.write(resq);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext){
        channelHandlerContext.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext,Throwable cause){
        channelHandlerContext.close();
    }
}
