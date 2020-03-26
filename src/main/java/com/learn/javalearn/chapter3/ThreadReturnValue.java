package networkCode.chapter3;

/**
 * Created by Administrator on 2017/3/5.
 */
public class ThreadReturnValue extends Thread {
    private String value1;
    private String value2;
    public  ThreadReturnValue(String value1){
        this.value1=value1;
    }

    @Override
    public void run() {
        value2=value1;
    }
    public String getValue2(){
        return value2;
    }
}
