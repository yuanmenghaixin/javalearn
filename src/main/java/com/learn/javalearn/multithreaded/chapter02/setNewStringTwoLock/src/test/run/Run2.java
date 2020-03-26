package multithreaded.chapter02.setNewStringTwoLock.src.test.run;

import multithreaded.chapter02.setNewStringTwoLock.src.myservice.MyService;
import multithreaded.chapter02.setNewStringTwoLock.src.extthread.ThreadA;
import multithreaded.chapter02.setNewStringTwoLock.src.extthread.ThreadB;

public class Run2 {

	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");

		ThreadB b = new ThreadB(service);
		b.setName("B");

		a.start();
		b.start();
	}
}
