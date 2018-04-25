package netty.chapter7.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
/*import org.msgpack.MessagePack;*/

/**
 * Created by Peng.lv on 2017/7/18.
 * 编码器的开发
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object>{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
   /* MessagePack msgpack=new MessagePack();
    //序列化
    byte[] raw=msgpack.write(o);
    byteBuf.writeBytes(raw);*/
    }
}
