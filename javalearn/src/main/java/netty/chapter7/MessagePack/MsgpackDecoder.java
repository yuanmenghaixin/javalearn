package netty.chapter7.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
/*
import org.msgpack.MessagePack;
*/

import java.util.List;

/**
 * Created by Peng.lv on 2017/7/18.
 * MsgpackDecoder解码器开发
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
       /* final byte[] array;
        final int length =byteBuf.readableBytes();
        array=new byte[length];
        byteBuf.getBytes(byteBuf.readerIndex(),array,0,length);
        MessagePack msgpack=new MessagePack();
        //反序列化
        list.add(msgpack.read(array));*/
    }
}
