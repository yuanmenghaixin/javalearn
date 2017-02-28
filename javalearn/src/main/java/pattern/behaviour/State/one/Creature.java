package pattern.behaviour.State.one;

/**
 * State状态设计模式类似于Switch多路分支功能的开关
 * 
 * @author Peng.lv
 *
 */
public class Creature {
	private Boolean isFrog = true;// 标识

	public void greet() {
		if (isFrog) {
			System.out.println("Ribbet!");
		} else {
			System.out.println("Darling!");
		}
	}

	// 转换标识
	public void kiss() {
		isFrog = false;
	}

	public static void main(String[] args) {
		Creature creature = new Creature();
		creature.greet();
		creature.kiss();
		creature.greet();
	}
}
