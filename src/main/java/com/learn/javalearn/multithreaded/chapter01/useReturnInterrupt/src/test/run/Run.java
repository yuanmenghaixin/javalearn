package multithreaded.chapter01.useReturnInterrupt.src.test.run;

import multithreaded.chapter01.useReturnInterrupt.src.extthread.MyThread;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyThread t=new MyThread();
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}

}
