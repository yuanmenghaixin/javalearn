package pattern.behaviour.Memento;
/**
 * 需要备忘的对象
 * Memento：存放Originator内部状态的对象。
 * @author Peng.lv
 *
 */
public class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
