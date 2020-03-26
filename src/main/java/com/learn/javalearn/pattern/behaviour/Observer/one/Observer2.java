package pattern.behaviour.Observer.one;

import java.util.Observable;
import java.util.Observer;

public class  Observer2 implements Observer {  
    public void update(Observable observable, Object arg1) {  
        System.out.println(observable+":观察者2收到了,通知内容：" +arg1);  
    }  
}
