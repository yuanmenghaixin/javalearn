package netty.nio;

/**
 * Created by Administrator on 2017/3/15.
 */
public class TimeServerMain {
    public static void main(String[] args){
        int port=8080;
        if(args!=null && args.length>0){
            port=Integer.valueOf(args[0]);
        }
        MultiplexerTimeServer timeServer= new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
