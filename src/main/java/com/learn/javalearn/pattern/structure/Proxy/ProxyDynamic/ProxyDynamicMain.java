package pattern.structure.Proxy.ProxyDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理，Java的动态代理只能针对接口进行动态代理，即要实现动态代理的类必须实现接口
 * 代理本质：不直接访问目标程序，通过代理简介访问目标程序
 * @author Peng.lv
 *
 */
public class ProxyDynamicMain {
	public static void main(String[] args) {
		ITarget targetImpl = new TargetImpl();
		InvocationHandler invocationHandler = new InvocationHandlerImpl(targetImpl);
		// 动态代理
		/*ITarget itarget = (ITarget) Proxy.newProxyInstance(InvocationHandlerImpl.class.getClassLoader(), new Class[] { ITarget.class},
				invocationHandlerImpl);*/
		ITarget itarget = (ITarget) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),targetImpl.getClass().getInterfaces() ,
				invocationHandler);
		System.out.println(itarget.getClass().getName());
		itarget.f("arg参数");
		itarget.g();
	}
}
