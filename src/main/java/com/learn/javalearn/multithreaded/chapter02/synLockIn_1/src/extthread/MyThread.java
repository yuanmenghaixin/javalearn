package multithreaded.chapter02.synLockIn_1.src.extthread;

import multithreaded.chapter02.synLockIn_1.src.myservice.Service;

public class MyThread extends Thread {
	@Override
	public void run() {
		Service service = new Service();
		service.service1();
	}

}
