package multithreaded.chapter01.t18.src.extthread;

public class MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("MyThread2 run priority=" + this.getPriority());
	}
}
