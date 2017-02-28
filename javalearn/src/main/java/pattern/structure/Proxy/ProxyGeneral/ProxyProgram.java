package pattern.structure.Proxy.ProxyGeneral;
/**
 *代理（对外开放--不直接访问目标程序，通过代理间接访问目标程序）
 * @author Peng.lv
 *
 */
public class ProxyProgram implements ProxyBase {
	private ProxyBase target;

	public ProxyProgram() {
		// 目标程序 创建真实目标程序
		target = new Target();
	}

	@Override
	public void f() {
		System.out.println("代理程序在调用目标程序前的处理");
		target.f();
		System.out.println("代理程序在调用目标程序后的处理");
	}
}
