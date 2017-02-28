package pattern.structure.Bridge.one;
/**
 * Dash:虚线
 * @author Peng.lv
 *
 */
public class DashDrawing implements Drawing {
	@Override
	public void draw(String shape) {
		System.out.println(shape+":Drawing dash line…");
	}

}
