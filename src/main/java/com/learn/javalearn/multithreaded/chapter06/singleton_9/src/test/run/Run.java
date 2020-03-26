package multithreaded.chapter06.singleton_9.src.test.run;

import multithreaded.chapter03.isaliveFALSE.src.extthread.MyThread;

public class Run {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();

		t1.start();
		t2.start();
		t3.start();

	}
}
