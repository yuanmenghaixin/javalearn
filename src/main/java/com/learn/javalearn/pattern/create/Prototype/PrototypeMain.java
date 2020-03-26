package pattern.create.Prototype;

public class PrototypeMain {
	public static void main(String[] args) {
		Shape shape = new Circle();
		System.out.println(shape.getShapeName());
		// 通过clone()方法获得一个对象拷贝
		Shape shape2 = (Shape) shape.clone();
		System.out.println(shape2.getShapeName());
	}
}
