package pattern.structure.Bridge.one;
/**
 * 长方形
 * @author Peng.lv
 *
 */
public class Rectangle implements Shape {
	private Drawing draw;

	public Rectangle(Drawing draw) {
		this.draw = draw;
	}

	@Override
	public void doDraw() {
		draw.draw("Rectangle");
	}

}
