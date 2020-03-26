package multithreaded.chapter03.join_sleep_1.src.test.run;

import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;
import multithreaded.chapter02.throwExceptionNoLock.src.extthread.ThreadB;
import multithreaded.chapter03.join_sleep_1.src.extthread.ThreadC;

public class Run {

	public static void main(String[] args) {

		try {
			ThreadB b = new ThreadB();

			ThreadA a = new ThreadA(b);
			a.start();

			Thread.sleep(1000);

			ThreadC c = new ThreadC(b);
			c.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
