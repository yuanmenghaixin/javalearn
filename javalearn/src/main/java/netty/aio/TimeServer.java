package netty.aio;

/**
 * Created by Administrator on 2017/3/17.
 * AIO时间服务器服务端
 */
public class TimeServer {
    public static void main(String[] args){
        int port=8080;
        if(args!=null&&args.length>0){
            port=Integer.valueOf(args[0]);
        }
        //首先创建异步的时间服务器处理类，然后启动线程将AsyncTimeServerHandler拉起
        AsyncTimeServerHandler timeServerHandler=new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler,"AIO-AsyncTimeServerHandler-001").start();
    }
}
