package pattern.structure.Proxy.ProxyDynamic;

/**
 *java动态代理处理类 （InvocationHandler：调用处理）
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
	private Object object;

	public InvocationHandlerImpl(Object obj) {
		this.object = obj;
	}

	/**
	 * @param proxy 指代我们所代理的那个真实对象
	 * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
	 * @param args 指代的是调用真实对象某个方法时接受的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before mothod:" + method);
		try {
			method.invoke(this.object, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("After mothod:" + method);
		return null;
	}

}
