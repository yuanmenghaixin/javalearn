package multithreaded.chapter07.selfAutoInnerClass.src.test.run;

import multithreaded.chapter07.selfAuto.src.extthread.SelfRun;

public class Run {

	public static void main(String[] args) {
		try {
			SelfRun autoRun = new SelfRun();
			Thread.sleep(5000);
			autoRun.stopRun();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
