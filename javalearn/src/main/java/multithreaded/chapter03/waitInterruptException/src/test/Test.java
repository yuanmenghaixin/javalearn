package multithreaded.chapter03.waitInterruptException.src.test;

import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;

public class Test {

	public static void main(String[] args) {

		try {
			Object lock = new Object();

			ThreadA a = new ThreadA(lock);
			a.start();

			Thread.sleep(5000);

			a.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
