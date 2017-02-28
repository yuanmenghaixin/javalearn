package pattern.create.Factory.FactorySimple.tow;
/**
 * 普通工厂模式:就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * @author Peng.lv
 *
 */
public class ShapeFactory {
	public static Shape createShape(String name)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// 使用java的反射机制来产生对象实例
		return (Shape) Class.forName(name).newInstance();
	}
}
