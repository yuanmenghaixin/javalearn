package multithreaded.chapter02.synMoreObjectStaticOneLock.src.extthread;

import multithreaded.chapter02.synMoreObjectStaticOneLock.src.service.Service;

public class ThreadA extends Thread {
	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printA();
	}
}
