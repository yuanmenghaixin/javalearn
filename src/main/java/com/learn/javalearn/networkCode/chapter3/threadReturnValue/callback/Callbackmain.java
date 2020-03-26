package networkCode.chapter3.threadReturnValue.callback;

/**
 * 通过回调的方式返回线程的值
 */
public class Callbackmain {
    public static void callback(String value){
       System.out.println("通过回调的方式返回线程值："+value);
    }
    public static void main(String[] args) {
        Callback t = new Callback("123");
        t.start();
    }
}
