package multithreaded.chapter01.countPriority.src.test;

import multithreaded.chapter01.countPriority.src.extthread.ThreadA;
import multithreaded.chapter01.countPriority.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {

		try {
			ThreadA a = new ThreadA();
			a.setPriority(Thread.NORM_PRIORITY - 3);
			a.start();

			ThreadB b = new ThreadB();
			b.setPriority(Thread.NORM_PRIORITY + 3);
			b.start();

			Thread.sleep(20000);
			a.stop();
			b.stop();

			System.out.println("a=" + a.getCount());
			System.out.println("b=" + b.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
