package pattern.create.Singleton;

/**
 * 饿汉单类模式即延迟初始化单类方式,一般认为饱汉模式要比饿汉模式更加安全。 基础的单例模式，Lazy模式，非线程安全 
 * 优点：lazy，初次使用时实例化单例，避免资源浪费 
 * 缺点：1、lazy，如果实例初始化非常耗时，初始使用时，可能造成性能问题
 * 
 * @author Peng.lv
 *
 */
public class Singleton2 {
	public static Singleton2 instance;

	// 延迟初始化的单类模式必须使用synchronized同步关键字，否则多线程情况下很容易产生多个实例对象
	public static synchronized Singleton2 getInstance() {
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
}
