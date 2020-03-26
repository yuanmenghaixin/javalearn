package multithreaded.chapter07.stateTest3.src.extthread;

import multithreaded.chapter04.MustUseMoreCondition_Error.src.service.MyService;

public class MyThread2 extends Thread {

	@Override
	public void run() {
		MyService.serviceMethod();
	}

}
