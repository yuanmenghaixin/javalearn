package netty.chapter6.JavaSerializable;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;


/**
 * Created by Peng.lv on 2017/7/18.
 */
public class UserInfoMain {
    public static void main(String[] args){
        UserInfo info =new UserInfo();
        info.buildUserID(100).buildUserName("Welcome to netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
            byte[] b=bos.toByteArray();
            System.out.println("The jdk Serializable length is:"+b.length);
            bos.close();
            System.out.println("-----------------------------------------");
            System.out.println("The byte array Serializable length is:"+info.codeC().length);
        } catch(Exception e){
            System.out.print("出错了"+e.getMessage());
        }
    }
}
