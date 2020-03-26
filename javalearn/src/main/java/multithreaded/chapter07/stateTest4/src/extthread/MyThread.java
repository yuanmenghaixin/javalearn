package multithreaded.chapter07.stateTest4.src.extthread;

import multithreaded.chapter07.stateTest4.src.service.Lock;

public class MyThread extends Thread {

	@Override
	public void run() {
		try {
			synchronized (Lock.lock) {
				Lock.lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
