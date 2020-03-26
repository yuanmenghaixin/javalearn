package multithreaded.chapter03.wait_notify_size5.src.test;

import multithreaded.chapter03.wait_notify_size5.src.extthread.ThreadA;
import multithreaded.chapter03.wait_notify_size5.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {

		try {
			Object lock = new Object();

			ThreadA a = new ThreadA(lock);
			a.start();

			Thread.sleep(50);

			ThreadB b = new ThreadB(lock);
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
