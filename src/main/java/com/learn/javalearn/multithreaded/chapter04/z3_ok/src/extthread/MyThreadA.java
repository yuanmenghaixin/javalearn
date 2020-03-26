package multithreaded.chapter04.z3_ok.src.extthread;

import multithreaded.chapter04.MustUseMoreCondition_Error.src.service.MyService;

public class MyThreadA extends Thread {

	private MyService myService;

	public MyThreadA(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.waitMethod();
	}

}
