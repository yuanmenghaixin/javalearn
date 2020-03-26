package multithreaded.chapter01.t11.src.exthread;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i=" + (i + 1));
		}
	}
}
