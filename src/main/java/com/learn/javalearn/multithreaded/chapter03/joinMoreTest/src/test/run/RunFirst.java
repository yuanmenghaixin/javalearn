package multithreaded.chapter03.joinMoreTest.src.test.run;

import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;
import multithreaded.chapter02.throwExceptionNoLock.src.extthread.ThreadB;

public class RunFirst {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		ThreadA a = new ThreadA(b);
		a.start();
		b.start();
		System.out.println("   main end=" + System.currentTimeMillis());
	}

}
