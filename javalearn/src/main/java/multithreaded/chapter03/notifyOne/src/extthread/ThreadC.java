package multithreaded.chapter03.notifyOne.src.extthread;

import multithreaded.chapter02.throwExceptionNoLock.src.service.Service;

public class ThreadC extends Thread {
	private Object lock;

	public ThreadC(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		Service service = new Service();
		service.testMethod(lock);
	}

}
