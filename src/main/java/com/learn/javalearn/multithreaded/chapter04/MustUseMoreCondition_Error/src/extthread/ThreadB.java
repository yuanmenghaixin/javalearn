package multithreaded.chapter04.MustUseMoreCondition_Error.src.extthread;

import multithreaded.chapter04.MustUseMoreCondition_Error.src.service.MyService;

public class ThreadB extends Thread {

	private MyService service;

	public ThreadB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitB();
	}
}
