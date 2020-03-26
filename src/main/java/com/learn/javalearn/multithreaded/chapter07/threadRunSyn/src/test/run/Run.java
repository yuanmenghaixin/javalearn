package multithreaded.chapter07.threadRunSyn.src.test.run;

import multithreaded.chapter07.groupInnerStop.src.mythread.MyThread;

public class Run {

	public static void main(String[] args) {

		Object lock = new Object();

		MyThread a = new MyThread(lock, "A", 1);
		MyThread b = new MyThread(lock, "B", 2);
		MyThread c = new MyThread(lock, "C", 0);

		a.start();
		b.start();
		c.start();

	}

}
