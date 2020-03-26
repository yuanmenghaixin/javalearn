package multithreaded.chapter02.doubleSynBlockOneTwo.src.extthread;

import multithreaded.chapter02.doubleSynBlockOneTwo.src.service.ObjectService;

public class ThreadA extends Thread {

	private ObjectService service;

	public ThreadA(ObjectService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.serviceMethodA();
	}

}
