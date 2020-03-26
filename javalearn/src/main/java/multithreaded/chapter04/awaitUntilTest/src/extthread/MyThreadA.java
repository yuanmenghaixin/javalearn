package multithreaded.chapter04.awaitUntilTest.src.extthread;

import multithreaded.chapter04.awaitUntilTest.src.service.Service;

public class MyThreadA extends Thread {

	private Service service;

	public MyThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.waitMethod();
	}

}
