package pattern.structure.Bridge.one;

/**
 * 
 * Bridge桥接设计模式是将一组功能(实现)与另一组使用该功能的其他对象(行为)分离开来,以便达到单一因素变化，然后使用对象调用的方式将这两组关联系起来，
 * 将问题的行为和实现分离开来实现，通过用聚合代替继承来解决子类爆炸性增长的问题。
 * (1).Bridge桥接设计模式中不但实现可以变化，问题行为也是可以变化的，且两者的变化是相互独立的，在两个维度都存在变化情况下优先考虑使用桥接模式。
 * (2).Strategy策略设计模式中，仅仅存在算法实现策略的变化，问题行为是不变的，即仅有一个维度的变化。另外策略模式中考虑的算法层次的变化，是无状态，
 * 无数据的。 JDK中桥接模式的应用： •AWT •JDBC
 * 
 * 
 * @author Peng.lv
 *
 */
public class BridgeDemoMain {
	public static void main(String[] args) {
		// 画一个实线的圆
		Drawing draw1 = new SolidDrawing();
		Drawing draw2 = new DashDrawing();
		// 画一个实线的圆
		Shape shape1 = new Circle(draw1);
		shape1.doDraw();
		// 画一个虚线的圆
		Shape shape3 = new Circle(draw2);
		shape3.doDraw();
		// 画一个虚线的矩形
		Shape shape2 = new Rectangle(draw2);
		shape2.doDraw();
	}
}
