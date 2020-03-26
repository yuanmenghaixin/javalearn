package netty.chapter8.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peng.lv on 2017/7/22.
 */
public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req){
      return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body){
        try {
            return SubscribeReqProto.SubscribeReq.parseFrom(body);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
        //创建实例
        SubscribeReqProto.SubscribeReq.Builder builder= SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("moyocode");
        builder.setProductName("Netty learn");
       /* List<String> address=new ArrayList<String>();
        address.add("shan dong");
        address.add("hangzhou");*/
        builder.setAddress("hang zhou");
        return builder.build();
    }

    public static void main(String[] args){
        SubscribeReqProto.SubscribeReq req=createSubscribeReq();
        System.out.println(req.toString());
    }
}
