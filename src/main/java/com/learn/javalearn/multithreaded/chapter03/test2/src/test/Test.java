package multithreaded.chapter03.test2.src.test;

import multithreaded.chapter03.test2.src.extthread.MyThread1;
import multithreaded.chapter03.test2.src.extthread.MyThread2;

public class Test {
	public static void main(String[] args) {
		try {
			Object lock = new Object();

			MyThread1 t1 = new MyThread1(lock);
			t1.start();

			Thread.sleep(3000);

			MyThread2 t2 = new MyThread2(lock);
			t2.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
