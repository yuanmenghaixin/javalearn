package pattern.create.Builder.one;

public class NutritionFacts_oldModle {
	// 用一个类表示包装食品外面显示的营养成分，其中每份含量和每罐含量是必须的，卡洛里，脂肪，纳和碳水化合物是可选参数。
	// 必须参数
	private final int servingSize;
	private final int servings;
	// 可选参数
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public NutritionFacts_oldModle(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}

	public NutritionFacts_oldModle(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}

	public NutritionFacts_oldModle(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public NutritionFacts_oldModle(int servingSize, int servings, int calories, int fat, int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0);
	}

	public NutritionFacts_oldModle(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFacts_oldModle cocaCola = new NutritionFacts_oldModle(240, 8, 100, 0, 35, 27);
	}
}
