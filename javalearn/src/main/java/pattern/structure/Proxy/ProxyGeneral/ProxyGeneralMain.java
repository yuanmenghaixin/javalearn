package pattern.structure.Proxy.ProxyGeneral;

/**
 * 普通的代理 客户端程序->代理程序->目标程序
 * 客户端程序通过代理程序来访问真正的目标程序，代理程序对外隐藏了目标程序。
 * @author Peng.lv
 *
 */
public class ProxyGeneralMain {
	public static void main(String[] args) {
		// 客户端调用代理程序
		ProxyBase p = new ProxyProgram();
		p.f();
	}
}
