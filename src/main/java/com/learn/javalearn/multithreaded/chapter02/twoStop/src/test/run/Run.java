package multithreaded.chapter02.twoStop.src.test.run;

import multithreaded.chapter02.throwExceptionNoLock.src.service.Service;
import multithreaded.chapter02.twoNoStop.src.extthread.ThreadA;
import multithreaded.chapter02.throwExceptionNoLock.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {
		Service service = new Service();

		ThreadA athread = new ThreadA(service);
		athread.start();

		ThreadB bthread = new ThreadB(service);
		bthread.start();
	}

}
