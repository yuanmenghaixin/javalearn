package pattern.behaviour.Memento;

/**
 * 保存（备忘）的原来对象 需要保存内部状态的对象。
 * 
 * @author Peng.lv Original 原来
 */
public class Originator {
	private String state;

	public Originator(String state) {
		this.state = state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento createMemento(String state) {
		return new Memento(state);
	}

	public void restoreMemento(Memento memento) {
		this.state = memento.getState();
	}
}
