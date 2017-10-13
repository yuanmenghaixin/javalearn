package netty.chapter7.MessagePack;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import netty.chapter6.JavaSerializable.UserInfo;

import java.util.logging.Logger;


/**
 * Created by Administrator on 2017/3/21.
 */
public class EchoClientHandler extends ChannelHandlerAdapter{
    private static final Logger logger=Logger.getLogger(EchoClientHandler.class.getName());
    private final int sendNumber;
    private int counter;
    private byte[] req;
    static final String ECHO_REQ="Hi,Lilinfen.Welcome to Netty.$_";

    public EchoClientHandler(int sendNumber) {
        this.sendNumber=sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] infos= UserInfo();
    }

    private UserInfo[] UserInfo(){
        UserInfo[] userInfos=new UserInfo[sendNumber];
        UserInfo userInfo=null;
        for(int i=0;i<sendNumber;i++){
            userInfo=new UserInfo();
            userInfo.setUserID(i);
            userInfo.setUserName("ABCDEFG --->"+i);
            userInfos[i]=userInfo;
        }
        return userInfos;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive the msgpack message:"+msg+";");
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
