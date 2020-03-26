package pattern.create.Builder.one;
/**
 * Builder建造者模式和AbstraceFactory抽象工厂模式的区别：
Builder建造者模式和AbstraceFactory抽象工厂模式非常类似，很多人经常分不清楚，区别如下：
(1).抽象工厂模式中，每一次工厂物件被呼叫时都会传回一个完整的产品物件，而使用端有可能会决定把这些产品组装成一个更大的和复杂的产品，也有可能不会。
工厂物件是没有状态的，不知道上一次构建的是哪一个产品，也没有未来的概念，不知道下一次构建的是哪一个产品，
更不知道自己构建的产品在更高层的产品结构蓝图中是什么位置。   
(2). 建造者模式不同，建造模式的重点在指导者(Director)角色。指导者是有状态的，它知道整体蓝图，知道上一次、
这一次和下一次交给建造者(Builder)角色去构建的零件是什么，以便能够将这些零件组装成一个更大规模的产品。
它一点一点地建造出一个复杂的产品，而这个产品的组装程式就发生在指导者角色内部。建造者模式的使用端拿到的是一个完整的最后产品。   
 换言之，虽然抽象工厂模式与建造模式都是设计模式，但是抽象工厂模式处在更加具体的尺度上，而建造模式则处于更加宏观的尺度上。
 一个系统可以由一个建造模式和一个抽象工厂模式组成，使用端通过呼叫这个导演角色，间接地呼叫另一个抽象工厂模式的工厂角色。
 工厂样式传回不同产品族的零件，而建造者模式则把它们组装起来。  
JDK中建造者模式的应用：
StringBuilder和StringBuffer的append()方法使用了建造者模式。
 * @author Peng.lv
 *
 */
public class NutritionFactsBuilder {
	// 必须参数
	private final int servingSize;
	private final int servings;
	// 可选参数
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	// 建造者
	public static class Builder {
		// 必须参数
		private final int servingSize;
		private final int servings;
		// 可选参数
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			this.calories = val;
			return this;
		}

		public Builder fat(int val) {
			this.fat = val;
			return this;
		}

		public Builder sodium(int val) {
			this.sodium = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			this.carbohydrate = val;
			return this;
		}

		public NutritionFactsBuilder build() {
			return new NutritionFactsBuilder(this);
		}
	}

	private NutritionFactsBuilder(Builder builder) {
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}
	
	public static void main(String[] args) {
		NutritionFactsBuilder cocaCola = new Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
	}


	
}
