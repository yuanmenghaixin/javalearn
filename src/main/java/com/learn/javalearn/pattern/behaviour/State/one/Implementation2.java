package pattern.behaviour.State.one;

//状态实现类2
public class Implementation2 implements State{
	@Override
	public void operation1() {
		System.out.println("Implementation2.operation1()");
	}

	@Override
	public void operation2() {
		System.out.println("Implementation2.operation2()");
	}

	@Override
	public void operation3() {
		System.out.println("Implementation2.operation3()");
	}
}
