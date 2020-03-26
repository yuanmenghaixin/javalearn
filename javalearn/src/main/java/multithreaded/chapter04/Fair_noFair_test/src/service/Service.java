package multithreaded.chapter04.Fair_noFair_test.src.service;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

	private ReentrantLock lock;

	public Service(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName()
					+ "获得锁定");
		} finally {
			lock.unlock();
		}
	}

}
