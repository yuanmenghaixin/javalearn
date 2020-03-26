package pattern.behaviour.Strategy.one;

/**
 * Strategy策略设计模式主要是定义一系列的算法，把这些算法封装成单独的类，在运行时动态选择需要的算法，策略模式机制如下：
 * 
 * @author Peng.lv
 *
 */
public abstract class TextStrategy {
	protected String text;

	public TextStrategy(String text) {
		this.text = text;
	}

	public abstract String replace();
}
