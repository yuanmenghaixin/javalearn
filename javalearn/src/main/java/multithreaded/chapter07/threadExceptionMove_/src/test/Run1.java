package multithreaded.chapter07.threadExceptionMove_.src.test;

import multithreaded.chapter07.threadExceptionMove_.src.test.extUncaughtExceptionHandler.StateUncaughtExceptionHandler;
import multithreaded.chapter03.isaliveFALSE.src.extthread.MyThread;

public class Run1 {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		// 对象
		// smyThread
		// .setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		// 类
		MyThread
				.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		myThread.start();
	}
}
