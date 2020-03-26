package multithreaded.chapter01.t4.src.mythread;

public class MyThread extends Thread {

	private int count=5;
	
	@Override
	synchronized public void run() {
		super.run();
			count--;
			System.out.println("�� "+this.currentThread().getName()+" ���㣬count="+count);
	}
}
