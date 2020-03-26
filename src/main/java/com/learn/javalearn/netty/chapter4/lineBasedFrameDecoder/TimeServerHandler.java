package netty.chapter4.lineBasedFrameDecoder;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;


/**
 * Created by Administrator on 2017/3/21.
 *
 * 每读取一条消息后，就记一次数，然后发送应答消息给客户端。按照设计，服务端接收到消息总数应该跟客户端发送的消息总数一致，而且请求消息删除回车换行符后
 * 应该为"QUERY TIME ORDER"
 */
public class TimeServerHandler extends ChannelHandlerAdapter{
    private  int counter;
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext,Object msg){
        String body=(String) msg;
        try {
            System.out.println("The time server receive order:"+body+"; the counter is:"+  ++counter);
            String currentTime="QUERY TIME ORDER".equalsIgnoreCase(body)?new java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
            currentTime=currentTime+System.getProperty("line.separator");
            ByteBuf resq= Unpooled.copiedBuffer(currentTime.getBytes());
            channelHandlerContext.writeAndFlush(resq);
        } catch (Exception e) {
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
