package multithreaded.chapter04.ConditionTestMoreMethod.src.test;

import multithreaded.chapter04.ConditionTestMoreMethod.src.service.MyService;
import multithreaded.chapter04.ConditionTestMoreMethod.src.extthread.ThreadA;
import multithreaded.chapter04.ConditionTestMoreMethod.src.extthread.ThreadAA;
import multithreaded.chapter04.ConditionTestMoreMethod.src.extthread.ThreadB;
import multithreaded.chapter04.ConditionTestMoreMethod.src.extthread.ThreadBB;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadAA aa = new ThreadAA(service);
		aa.setName("AA");
		aa.start();

		Thread.sleep(100);

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
		
		ThreadBB bb = new ThreadBB(service);
		bb.setName("BB");
		bb.start();

	}

}
