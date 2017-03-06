package networkCode.chapter3.threadReturnValue.callback;

/**
 * Created by Administrator on 2017/3/5.
 */
public class Callback extends Thread {
    private String value1;
    private String value2;
    public Callback(String value1){
        this.value1=value1;
    }

    @Override
    public void run() {
        value2=value1;
        Callbackmain.callback(value2);
    }
    public String getValue2(){
        return value2;
    }
}
