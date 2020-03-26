package multithreaded.chapter01.t15.src.test;

import multithreaded.chapter01.t12.src.exthread.MyThread;

public class Run {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		thread.interrupt();
		System.out.println("end!");
	}
}
