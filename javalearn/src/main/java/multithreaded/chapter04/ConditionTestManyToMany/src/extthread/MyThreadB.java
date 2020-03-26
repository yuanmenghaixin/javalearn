package multithreaded.chapter04.ConditionTestManyToMany.src.extthread;

import multithreaded.chapter04.ConditionTestManyToMany.src.service.MyService;

public class MyThreadB extends Thread {

	private MyService myService;

	public MyThreadB(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			myService.get();
		}
	}

}
