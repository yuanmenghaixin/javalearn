package multithreaded.chapter01.t7.src.mythread;

public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("run=" + this.isAlive());
	}
}
