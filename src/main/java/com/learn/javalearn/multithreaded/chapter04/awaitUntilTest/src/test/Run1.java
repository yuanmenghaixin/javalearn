package multithreaded.chapter04.awaitUntilTest.src.test;

import multithreaded.chapter04.awaitUntilTest.src.service.Service;
import multithreaded.chapter04.awaitUntilTest.src.extthread.MyThreadA;

public class Run1 {

	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		MyThreadA myThreadA = new MyThreadA(service);
		myThreadA.start();
	}

}
