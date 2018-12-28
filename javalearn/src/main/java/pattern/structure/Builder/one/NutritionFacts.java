package pattern.structure.Builder.one;

/**
 * Builder建造者模式将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。Builder模式是一步一步创建一个复杂的对象，
 * 它允许用户可以只通过指定复杂对象的类型和内容就可以构建它们，用户不需要了解所构建对象的内部具体构建细节，
 * Builder建造设计模式的目的是为了将构造复杂对象的过程和它的部件解耦。
 * Builder建造者设计模式中有两个重要角色：Director指导者和Builder建造者。Director指导者相当于设计师或架构师，
 * 拥有整个产品各个部件之间关系的构建蓝图。Builder建造者是部件的具体创建者，Builder建造者根据Director指导者的指示创建产品的各个部件，
 * 最终由Director构建出完整产品。
 * 
 * @author Peng.lv
 *
 */
public class NutritionFacts {
	// 用一个类表示包装食品外面显示的营养成分，其中每份含量和每罐含量是必须的，卡洛里，脂肪，纳和碳水化合物是可选参数。
	// 必须参数
	private int servingSize = -1;
	private int servings = -1;
	// 可选参数
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;

	public NutritionFacts() {
	}

	public void setServingSize(int val) {
		this.servingSize = val;
	}

	public void setServings(int val) {
		this.servings = val;
	}

	public void setCalories(int val) {
		this.calories = val;
	}

	public void setFat(int val) {
		this.fat = val;
	}

	public void setSodium(int val) {
		this.sodium = val;
	}

	public void setCarbohydrate(int val) {
		this.carbohydrate = val;
	}

	public int getServingSize() {
		return servingSize;
	}

	public int getServings() {
		return servings;
	}

	public int getCalories() {
		return calories;
	}

	public int getFat() {
		return fat;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	// 使用setter方法可以弥补重载构造方法的缺陷，创建实例对象很容易，并且代码也容易阅读：
	// 由于javaBean自身有着很严重的缺点，构造过程被分到了几个调用中，在构造过程中java
	// Bean可能处于不一致的状态，类无法仅仅通过检验构造方法参数的有效性来保证一致性，使用处于不一致状态的对象将会导致失败。
	// 另外javaBean阻止了把类做成不可变的可能，因此很难确保线程安全。
	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setFat(27);
	}
}
