package pattern.behaviour.Observer.two;
/**
 * 二进制创建实体观察者类
 * @author Peng.lv
 *
 */
public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
	}
}
