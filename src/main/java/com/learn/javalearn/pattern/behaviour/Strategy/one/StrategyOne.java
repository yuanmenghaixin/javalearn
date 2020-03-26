package pattern.behaviour.Strategy.one;

/**
 * //替换算法1：将文本中"@r@n"替换为"@n"
 * 
 * @author Peng.lv
 *
 */
public class StrategyOne extends TextStrategy {
	public StrategyOne(String text) {
		super(text);
	}

	@Override
	public String replace() {
		System.out.println("StrategyOne:");
		String result = text.replaceAll("@r@n", "@n");
		return result;
	}
}
