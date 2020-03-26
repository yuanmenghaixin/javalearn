package multithreaded.chapter04.ReentrantLockTest.src.extthread;

import multithreaded.chapter04.MustUseMoreCondition_Error.src.service.MyService;

public class MyThread extends Thread {

	private MyService service;

	public MyThread(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}
