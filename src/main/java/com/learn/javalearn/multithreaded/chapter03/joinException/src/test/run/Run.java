package multithreaded.chapter03.joinException.src.test.run;

import multithreaded.chapter02.throwExceptionNoLock.src.extthread.ThreadB;
import multithreaded.chapter03.join_sleep_1.src.extthread.ThreadC;

public class Run {

	public static void main(String[] args) {

		try {
			ThreadB b = new ThreadB();
			b.start();

			Thread.sleep(500);

			ThreadC c = new ThreadC(b);
			c.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
