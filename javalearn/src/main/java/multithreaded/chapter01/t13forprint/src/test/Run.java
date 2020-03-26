package multithreaded.chapter01.t13forprint.src.test;

import multithreaded.chapter01.t13forprint.src.exthread.MyThread;
import multithreaded.chapter01.t13forprint.src.exthread.MyThread;

public class Run {

	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
