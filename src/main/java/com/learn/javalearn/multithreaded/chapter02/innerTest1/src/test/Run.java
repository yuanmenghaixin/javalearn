package multithreaded.chapter02.innerTest1.src.test;

import multithreaded.chapter02.innerTest1.src.test.OutClass.Inner;

public class Run {
	public static void main(String[] args) {

		final Inner inner = new Inner();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				inner.method1();
			}
		}, "A");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				inner.method2();
			}
		}, "B");

		t1.start();
		t2.start();

	}
}