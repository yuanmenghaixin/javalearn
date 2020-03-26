package multithreaded.chapter02.twoStop.src.extthread;

import multithreaded.chapter02.throwExceptionNoLock.src.service.Service;

public class ThreadA extends Thread {

	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}

}
