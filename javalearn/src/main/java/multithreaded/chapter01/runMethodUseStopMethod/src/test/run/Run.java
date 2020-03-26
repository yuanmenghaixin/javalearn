package multithreaded.chapter01.runMethodUseStopMethod.src.test.run;

import multithreaded.chapter01.useStopMethodThreadTest.src.testpackage.MyThread;

public class Run {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
	}
}
