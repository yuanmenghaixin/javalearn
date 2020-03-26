package multithreaded.chapter01.suspend_resume_LockStop.src.mythread;

public class MyThread extends Thread {
	private long i = 0;

	@Override
	public void run() {
		while (true) {
			i++;
			System.out.println(i);
		}
	}
}
