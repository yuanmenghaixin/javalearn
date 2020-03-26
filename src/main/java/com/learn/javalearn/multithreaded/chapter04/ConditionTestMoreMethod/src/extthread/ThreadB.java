package multithreaded.chapter04.ConditionTestMoreMethod.src.extthread;

import multithreaded.chapter04.ConditionTestMoreMethod.src.service.MyService;

public class ThreadB extends Thread {

	private MyService service;

	public ThreadB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}
}
