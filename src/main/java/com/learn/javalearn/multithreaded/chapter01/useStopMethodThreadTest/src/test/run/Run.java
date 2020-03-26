package multithreaded.chapter01.useStopMethodThreadTest.src.test.run;

import multithreaded.chapter01.useStopMethodThreadTest.src.testpackage.MyThread;

public class Run {

	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(8000);
			thread.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
