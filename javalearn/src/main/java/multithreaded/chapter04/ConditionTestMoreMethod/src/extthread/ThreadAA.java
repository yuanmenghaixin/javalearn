package multithreaded.chapter04.ConditionTestMoreMethod.src.extthread;

import multithreaded.chapter04.ConditionTestMoreMethod.src.service.MyService;

public class ThreadAA extends Thread {

	private MyService service;

	public ThreadAA(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}
}
