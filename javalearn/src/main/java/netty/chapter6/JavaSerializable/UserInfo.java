package netty.chapter6.JavaSerializable;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by Peng.lv on 2017/7/18.
 */
public class UserInfo implements Serializable {
    private static  final long serialVersionUID=1L;
    private String userName;
    private int userID;
    public UserInfo buildUserName(String userName){
        this.userName=userName;
        return this;
    }

    public UserInfo buildUserID(int userID){
        this.userID=userID;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * 使用基于Bytebuffer的通用二进制编码技术对UserInfo对象进行编码，编码结果仍然是byte数组，可以与传统的JDK序列化后的流码大小进行比较
     * @return
     */
    public byte[] codeC(){
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        byte[] value=this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userID);
        buffer.flip();
        value=null;
        byte[] result=new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
