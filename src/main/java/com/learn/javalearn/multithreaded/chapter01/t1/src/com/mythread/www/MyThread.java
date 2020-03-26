package multithreaded.chapter01.t1.src.com.mythread.www;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread");
	}
}
