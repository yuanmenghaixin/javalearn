package netty.aio;

/**
 * Created by Administrator on 2017/3/18.
 */
public class TimeClientMain {
    public static void main(String[] args){
        int port=8080;
        if(args!=null && args.length>0){
            port=Integer.valueOf(args[0]);
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"AIO-AsyncTimeClientHandler-001").start();
    }
}
