package multithreaded.chapter04.awaitUninterruptiblyTest_1.src.test;

import multithreaded.chapter04.awaitUninterruptiblyTest_1.src.service.Service;
import multithreaded.chapter04.awaitUninterruptiblyTest_1.src.extthread.MyThread;

public class Run {

	public static void main(String[] args) {
		try {
			Service service = new Service();
			MyThread myThread = new MyThread(service);
			myThread.start();
			Thread.sleep(3000);
			myThread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
