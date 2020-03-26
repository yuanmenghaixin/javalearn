package pattern.structure.Proxy.ProxyDynamic;

/**
 * 接口实现类，即被代理类（目标类）
 * 
 * @author Peng.lv
 *
 */
public class TargetImpl implements ITarget {
	public void f(String s) {
		System.out.println("TargetImpl.f(), s=" + s);
	}

	public void g() {
		System.out.println("TargetImpl.g()");

	}
}
