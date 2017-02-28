package pattern.behaviour.Command.one;
/**
 * 创建实现了 Order 接口的实体类。
 * @author Peng.lv
 *
 */
public class SellStock  implements Order {
	private Stock abcStock;

	public SellStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	@Override
	public void execute() {
		abcStock.sell();
	}
}
