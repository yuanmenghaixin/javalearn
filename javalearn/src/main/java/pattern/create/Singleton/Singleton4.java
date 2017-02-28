package pattern.create.Singleton;

/**
 * 用枚举，最好的实现方式
 * 
 * @author Peng.lv
 *
 */
public enum Singleton4 {
	INSTANCE {
		@Override
		public String doSomeThing() {
			return "单例类中的方法";
		}
	};

	public abstract String doSomeThing();
}
