package pattern.structure.Bridge.two;
/**
 * 桥接模式的核心类
 * @author Peng.lv
 *
 */
public abstract class Bridge {
	private Sourceable source;

	public void method() {
		source.method();
	}

	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}
}
