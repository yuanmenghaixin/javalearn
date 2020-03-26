package multithreaded.chapter03.notifyOne.src.extthread;

import multithreaded.chapter02.throwExceptionNoLock.src.service.Service;

public class ThreadB extends Thread {
	private Object lock;

	public ThreadB(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		Service service = new Service();
		service.testMethod(lock);
	}

}
