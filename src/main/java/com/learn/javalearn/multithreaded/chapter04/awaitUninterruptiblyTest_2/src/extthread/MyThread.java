package multithreaded.chapter04.awaitUninterruptiblyTest_2.src.extthread;

import multithreaded.chapter04.awaitUninterruptiblyTest_2.src.service.Service;

public class MyThread extends Thread {

	private Service service;

	public MyThread(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}

}
