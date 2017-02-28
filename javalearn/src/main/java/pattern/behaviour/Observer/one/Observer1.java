package pattern.behaviour.Observer.one;
/**
 * Observer:观察者，观察员
 */
import java.util.Observable;
import java.util.Observer;

public class  Observer1 implements Observer {  
    public void update(Observable observable, Object arg1) {  
        System.out.println(observable+":观察者一收到了，通知内容："+arg1);  
    }  
}
