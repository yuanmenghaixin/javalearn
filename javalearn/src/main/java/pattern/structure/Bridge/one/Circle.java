package pattern.structure.Bridge.one;
/**
 * 圆
 * @author Peng.lv
 *
 */
public class Circle implements Shape {
	private Drawing draw;

	public Circle(Drawing draw) {
		this.draw = draw;
	}

	@Override
	public void doDraw() {
		draw.draw("Circle");
	}

}
