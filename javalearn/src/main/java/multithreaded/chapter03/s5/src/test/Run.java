package multithreaded.chapter03.s5.src.test;

import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;
import multithreaded.chapter02.throwExceptionNoLock.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {
		try {
			ThreadA a = new ThreadA();
			a.start();

			Thread.sleep(1000);

			ThreadB b = new ThreadB();
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
