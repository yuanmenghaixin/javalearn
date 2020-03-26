package multithreaded.chapter04.tryLockTest.src.service;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {

	public ReentrantLock lock = new ReentrantLock();

	public void waitMethod() {
		if (lock.tryLock()) {
			System.out.println(Thread.currentThread().getName() + "�����");
		} else {
			System.out.println(Thread.currentThread().getName() + "û�л����");
		}
	}
}
