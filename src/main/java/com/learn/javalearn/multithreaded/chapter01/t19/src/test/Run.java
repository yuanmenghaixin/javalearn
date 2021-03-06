package multithreaded.chapter01.t19.src.test;

import multithreaded.chapter03.test2.src.extthread.MyThread1;
import multithreaded.chapter03.test2.src.extthread.MyThread2;

public class Run {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			MyThread1 thread1 = new MyThread1();
			thread1.setPriority(1);
			thread1.start();

			MyThread2 thread2 = new MyThread2();
			thread2.setPriority(10);
			thread2.start();
		}
	}
}
