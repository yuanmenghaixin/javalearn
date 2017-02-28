package pattern.behaviour.Memento;

import java.util.Stack;

/**
 * 保存堆栈 Storage：为Originator保存并恢复状态的对象。
 * 
 * @author Peng.lv Caretaker守护者
 */
public class Storage {
	private Stack<Memento> mementos = new Stack<Memento>();

	private Memento memento;

	public Storage() {

	}

	public Storage(Memento memento) {
		this.memento = memento;
	}

	public void addMemento(Memento m) {
		mementos.push(m);
	}

	public Memento getMemento() {
		if (!mementos.empty()) {
			return mementos.pop();
		}
		return null;
	}
	public Memento getMemento2() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}

}
