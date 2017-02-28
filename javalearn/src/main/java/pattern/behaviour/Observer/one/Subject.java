package pattern.behaviour.Observer.one;

import java.util.Observable;

/**
 * Observable:观察得到的
 * @author Peng.lv
 *
 */
public class Subject extends Observable {
	public void change(String msg){  
        setChanged();
        //clearChanged();
        System.out.println(msg);  
        notifyObservers(msg);
    }  
}
