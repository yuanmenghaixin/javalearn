package pattern.create.Singleton;

/**
 * 饱汉模式，声明时就创建实例对象
 * 预先初始化static变量 的单例模式  非Lazy  线程安全
 3  * 优点：
 4  * 1、线程安全 
 5  * 缺点：
 6  * 1、非懒加载，如果构造的单例很大，构造完又迟迟不使用，会导致资源浪费。
 * @author Peng.lv
 *
 */
public class Singleton1 {
	public static final Singleton1 instance = new Singleton1();

	public static Singleton1 getInstance() {
		return instance;
	}
}
