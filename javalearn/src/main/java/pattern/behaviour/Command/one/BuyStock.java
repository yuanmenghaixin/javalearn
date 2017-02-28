package pattern.behaviour.Command.one;
/**
 * 创建实现了 Order 接口的实体类。
 * @author Peng.lv
 *
 */
public class BuyStock implements Order {
	private Stock abcStock;

	public BuyStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	@Override
	public void execute() {
		abcStock.buy();
	}
}
