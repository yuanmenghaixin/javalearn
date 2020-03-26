package pattern.behaviour.TemplateMethod;
/**
 * 打板球游戏
 * @author Peng.lv
 *
 */
public class Cricket extends Game {

	@Override
	void endPlay() {
		System.out.println("Cricket Game Finished!");
	}

	@Override
	void initialize() {
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket Game Started. Enjoy the game!");
	}

}
