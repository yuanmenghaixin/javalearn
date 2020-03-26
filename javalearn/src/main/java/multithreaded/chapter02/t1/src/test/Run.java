package multithreaded.chapter02.t1.src.test;

import multithreaded.chapter02.t1.src.service.HasSelfPrivateNum;
import multithreaded.chapter02.t1.src.extthread.ThreadA;
import multithreaded.chapter02.t1.src.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {

		HasSelfPrivateNum numRef = new HasSelfPrivateNum();

		ThreadA athread = new ThreadA(numRef);
		athread.start();

		ThreadB bthread = new ThreadB(numRef);
		bthread.start();

	}

}
