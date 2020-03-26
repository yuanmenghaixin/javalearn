package multithreaded.chapter04.MustUseMoreCondition_Error.src.test;

import multithreaded.chapter04.MustUseMoreCondition_Error.src.extthread.ThreadA;
import multithreaded.chapter04.MustUseMoreCondition_Error.src.extthread.ThreadB;
import multithreaded.chapter04.MustUseMoreCondition_Error.src.service.MyService;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		Thread.sleep(3000);

		service.signalAll();

	}

}
