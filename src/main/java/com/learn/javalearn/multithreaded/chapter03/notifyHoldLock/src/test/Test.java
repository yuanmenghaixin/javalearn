package multithreaded.chapter03.notifyHoldLock.src.test;

import multithreaded.chapter03.notifyAll.src.extthread.NotifyThread;
import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;
import multithreaded.chapter03.notifyHoldLock.src.extthread.synNotifyMethodThread;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();

		ThreadA a = new ThreadA(lock);
		a.start();

		NotifyThread notifyThread = new NotifyThread(lock);
		notifyThread.start();

		synNotifyMethodThread c = new synNotifyMethodThread(lock);
		c.start();

	}

}
