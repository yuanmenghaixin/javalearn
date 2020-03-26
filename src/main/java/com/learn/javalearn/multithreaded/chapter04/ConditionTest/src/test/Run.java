package multithreaded.chapter04.ConditionTest.src.test;

import multithreaded.chapter04.ConditionTest.src.service.MyService;
import multithreaded.chapter04.ConditionTest.src.extthread.MyThreadA;
import multithreaded.chapter04.ConditionTest.src.extthread.MyThreadB;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();

		MyThreadA a = new MyThreadA(myService);
		a.start();

		MyThreadB b = new MyThreadB(myService);
		b.start();

	}
}
