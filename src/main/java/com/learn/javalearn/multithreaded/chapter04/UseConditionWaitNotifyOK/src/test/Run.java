package multithreaded.chapter04.UseConditionWaitNotifyOK.src.test;

import multithreaded.chapter04.MustUseMoreCondition_Error.src.service.MyService;
import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.start();

		Thread.sleep(3000);

		service.signal();

	}

}
