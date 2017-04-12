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
        //类型转换，将MSG转换成netty的ByteBuf对象，ByteBuf类似于JDK中的Java.nio.ByteBuffer对象，不过它提供了更加强大和灵活的功能。
        //通过ByteBuf的readableBytes方法可以获取缓冲区可读的字节数，根据可读的字节数创建byte数组，通过ByteBuf的readBytes方法将缓冲区中的字节数组
        //复制到新建的byte数组中，最后通过new String构造函数获取请求消息。这时对请求消息进行判断，如果是“QUERY TIME ORDER”，则创建应答消息，
        // 通过channelHandlerContext的write方法异步发送应答消息给客户端。
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
        //channelHandlerContext的flush方法，它的作用是将消息发送队列中的消息写入到SocketChannel中发送给对方
        channelHandlerContext.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext,Throwable cause){
        channelHandlerContext.close();
    }
}
