package pattern.structure.Bridge.one;

/**
 * Solid:adj. 固体的; 实心的; 结实的，可靠的; 可信赖的;
 * 
 * @author Peng.lv
 *
 */
public class SolidDrawing implements Drawing {
	@Override
	public void draw(String shape) {
		System.out.println(shape+":Drawing solide line…");
	}
}
