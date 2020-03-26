package multithreaded.chapter01.suspend_resume_test.src.test.run;

import multithreaded.chapter01.suspend_resume_test.src.mythread.MyThread;

public class Run {

	public static void main(String[] args) {

		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(5000);
			// A
			thread.suspend();
			System.out.println("A= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			Thread.sleep(5000);
			System.out.println("A= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			// B
			thread.resume();
			Thread.sleep(5000);

			// C
			thread.suspend();
			System.out.println("B= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			Thread.sleep(5000);
			System.out.println("B= " + System.currentTimeMillis() + " i="
					+ thread.getI());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
