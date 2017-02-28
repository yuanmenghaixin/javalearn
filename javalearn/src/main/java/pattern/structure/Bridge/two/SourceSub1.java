package pattern.structure.Bridge.two;
/**
 * 实现类1
 * @author Peng.lv
 *
 */
public class SourceSub1 implements Sourceable {
	@Override
	public void method() {
		System.out.println("this is the first sub!");
	}

}
