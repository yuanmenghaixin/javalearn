package multithreaded.chapter04.awaitUninterruptiblyTest_2.src.test;

import multithreaded.chapter04.awaitUninterruptiblyTest_2.src.service.Service;
import multithreaded.chapter04.awaitUninterruptiblyTest_2.src.extthread.MyThread;

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
