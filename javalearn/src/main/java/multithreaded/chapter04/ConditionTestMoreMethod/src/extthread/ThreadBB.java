package multithreaded.chapter04.ConditionTestMoreMethod.src.extthread;

import multithreaded.chapter04.ConditionTestMoreMethod.src.service.MyService;

public class ThreadBB extends Thread {

	private MyService service;

	public ThreadBB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}
}
