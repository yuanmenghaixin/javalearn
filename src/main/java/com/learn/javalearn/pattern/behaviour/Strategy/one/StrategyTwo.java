package pattern.behaviour.Strategy.one;

/**
 * 替换算法2：将文本中"@n"替换为"@r@n"
 * 
 * @author Peng.lv
 *
 */
public class StrategyTwo extends TextStrategy {

	public StrategyTwo(String text) {
		super(text);
	}

	@Override
	public String replace() {
		System.out.println("StrategyTwo:");
		String result = text.replaceAll("@n", "@r@n");
		return result;
	}

}
