package multithreaded.chapter03.waitReleaseLock.src.extthread;

import multithreaded.chapter03.waitReleaseLock.src.service.Service;

public class ThreadA extends Thread {

	private Object lock;

	public ThreadA(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		Service service = new Service();
		service.testMethod(lock);
	}

}
