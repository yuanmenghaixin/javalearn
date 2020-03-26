package multithreaded.chapter03.waitReleaseLock.src.test;

import multithreaded.chapter03.waitReleaseLock.src.extthread.ThreadA;
import multithreaded.chapter03.waitReleaseLock.src.extthread.ThreadB;

public class Test {

	public static void main(String[] args) {

		Object lock = new Object();

		ThreadA a = new ThreadA(lock);
		a.start();

		ThreadB b = new ThreadB(lock);
		b.start();

	}

}
