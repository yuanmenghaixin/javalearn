package multithreaded.chapter07.threadExceptionMove_.src.test;

import multithreaded.chapter03.isaliveFALSE.src.extthread.MyThread;
import multithreaded.chapter07.threadExceptionMove_.src.extthreadgroup.MyThreadGroup;

public class Run2 {

	public static void main(String[] args) {
		multithreaded.chapter07.threadExceptionMove_.src.extthreadgroup.MyThreadGroup group = new MyThreadGroup("我的线程组");
		MyThread myThread = new MyThread(group, "我的线程");
		// 对象
		// myThread
		// .setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		// 类
		// MyThread
		// .setDefaultUncaughtExceptionHandler(new
		// StateUncaughtExceptionHandler());
		myThread.start();

	}
}
