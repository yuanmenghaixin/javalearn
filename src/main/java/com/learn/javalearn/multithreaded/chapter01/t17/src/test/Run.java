package multithreaded.chapter01.t17.src.test;

import multithreaded.chapter03.isaliveFALSE.src.extthread.MyThread;

public class Run {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
	}

}
