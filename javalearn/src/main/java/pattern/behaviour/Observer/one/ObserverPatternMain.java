package pattern.behaviour.Observer.one;

/**
 * Observer观察者设计模式用于将对象的变化通知给感兴趣的用户。在Observer模式中的角色为主题（subject）与观察者（observer），
 * 观察者订阅它感兴趣的主题，一个主题可以被多个观 察者订阅，当主题的状态发生变化时，
 * 它必须通知（notify）所有订阅它的观察者，观察者检视主题的状态变化，并作出对应的动作
 * (1).java.util.Observable是主题类，所有继承了该类的类是事件发生的主题，也是被观察的对象。java.util.
 * Observable的常用方法有： a.public void addObserver(Observer o)：为主题添加观察者。
 * b.publicvoid deleteObserver(Observer o)：删除某个观察者。 c.publicvoid
 * deleteObservers()：删除主题上的所有观察者。 d.publicboolean hasChanged()：测试主题是否改变。
 * e.protectedvoid setChanged()：标记该主题对象已经改变。 f.publicvoid
 * notifyObservers()：通知所有观察者对象已经已经改变。
 * (2).java.util.Observer接口是观察者，所有实现了该接口的类都是主题事件的观察者，该接口只有一个方法需要实现： publicvoid
 * update(Observable o, Object arg)：通知观察者更新已经改变的主题。
 * 
 * @author Peng.lv
 *
 */
public class ObserverPatternMain {
	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer1 obj1 = new Observer1();
		subject.addObserver(obj1);
		// subject.change("第一次通知:我是主题，我发生了变化");
		Observer2 obj2 = new Observer2();
		subject.addObserver(obj2);
		subject.change("我是主题，我发生了变化");
	}
}
