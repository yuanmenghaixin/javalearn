package multithreaded.chapter03.waitInterruptException.src.extthread;

import multithreaded.chapter02.throwExceptionNoLock.src.service.Service;

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
