package pattern.create.Factory.FactorySimple.tow;

public class FactorySimpleMain {
	public static void draw(Shape shape) {
		shape.draw();
	}
/**
 * 普通工厂模式:就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * @param args
 */
	public static void main(String[] args) {
		try {
			draw(ShapeFactory.createShape("com.hzb.factory.Circle"));
			draw(ShapeFactory.createShape("com.hzb.factory.Rectangle"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
