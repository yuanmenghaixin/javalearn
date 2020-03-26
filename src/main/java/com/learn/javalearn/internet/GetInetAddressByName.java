package internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/3/8.
 */
public class GetInetAddressByName {
    public static void main(String[] args){
        try {
            InetAddress address= InetAddress.getByName("www.baidu.com");
            InetAddress addressName= InetAddress.getByName("115.239.211.112");
            System.out.println(address);
            System.out.println("域名："+addressName.getHostName());
            InetAddress[] addresses=InetAddress.getAllByName("www.baidu.com");
            for(InetAddress inetAddress:addresses){
            System.out.println(inetAddress);
            }
        } catch (UnknownHostException e) {
           System.out.println(e.getMessage());
        }
    }
}
