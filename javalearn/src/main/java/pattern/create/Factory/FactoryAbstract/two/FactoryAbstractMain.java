package pattern.create.Factory.FactoryAbstract.two;

/**
 * 抽象工厂模式：抽象工厂模式中可以包括多个抽象产品类，每个抽象产品类可以产生出多个具体产品类，
 * 一个抽象工厂用于定义所需产品的组合形式，抽象工厂派生具体工厂类，这些具体工厂类就是简单工厂模式中的工厂类， 
 * 具体工厂类负责具体产品实例的创建：
 * 
 * @author Peng.lv
 *
 */
public class FactoryAbstractMain {
	/**
	 * 工厂模式中，重要的是工厂类，而不是产品类。产品类可以是多种形式，多层继承或者是单个类都是可以的。但要明确的，工厂模式的接口只会返回一种类型的实例，这是在设计产品类的时候需要注意的，最好是有父类或者共同实现的接口。
	 * 使用工厂模式，返回的实例一定是工厂创建的，而不是从其他对象中获取的。工厂模式返回的实例可以不是新创建的，返回由工厂创建好的实例也是可以的。
	  * 三种工厂模式的区别：
	  * 简单工厂 ： 用来生产同一等级结构中的任意产品，对于增加新的产品，无能为力。
	  * 工厂方法 ：用来生产同一等级结构中的固定产品，支持增加任意产品。
	  * 抽象工厂 ：用来生产不同产品族(由不同产品组合成的一套产品)的全部产品，对于增加新的产品，无能为力；支持增加产品族。
	 * @param args
	 */
	public static void main(String[] args) {
		// 显示一套IOS皮肤
		Skin skin = new Skin(new IOSSkinFactory());
		skin.showSkin();
		// 换一套Android的皮肤
		skin.setSkinFactory(new AndroidSkinFactory());
		skin.showSkin();
	}
}
