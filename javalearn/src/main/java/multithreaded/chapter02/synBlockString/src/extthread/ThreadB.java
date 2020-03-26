package multithreaded.chapter02.synBlockString.src.extthread;

import multithreaded.chapter02.synBlockString.src.service.Service;

public class ThreadB extends Thread {

	private Service service;

	public ThreadB(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.setUsernamePassword("b", "bb");

	}

}
