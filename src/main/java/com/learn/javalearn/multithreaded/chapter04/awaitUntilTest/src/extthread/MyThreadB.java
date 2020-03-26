package multithreaded.chapter04.awaitUntilTest.src.extthread;

import multithreaded.chapter04.awaitUntilTest.src.service.Service;

public class MyThreadB extends Thread {

	private Service service;

	public MyThreadB(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.notifyMethod();
	}

}
