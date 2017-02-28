package pattern.behaviour.State.one;

public class StateMain {
	private static ServiceProvider sp = new ServiceProvider(new Implementation1());

	private void run(ServiceProvider sp) {
		sp.service1();
		sp.service2();
		sp.service3();
	}

	public static void main(String[] args) {
		StateMain demo = new StateMain();
		demo.run(sp);
		sp.changeState(new Implementation2());
		demo.run(sp);
	}
}
