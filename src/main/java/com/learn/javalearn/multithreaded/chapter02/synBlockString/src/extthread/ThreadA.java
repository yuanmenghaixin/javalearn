package multithreaded.chapter02.synBlockString.src.extthread;

import multithreaded.chapter02.synBlockString.src.service.Service;

public class ThreadA extends Thread {
	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.setUsernamePassword("a", "aa");

	}

}
