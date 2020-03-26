package multithreaded.chapter02.t7.src.test;

import multithreaded.chapter02.t7.src.mytask.Task;
import multithreaded.chapter02.t7.src.mythread.MyThread1;
import multithreaded.chapter02.t7.src.mythread.MyThread2;

public class Run {

	public static void main(String[] args) {
		Task task = new Task();

		MyThread1 thread1 = new MyThread1(task);
		thread1.start();

		MyThread2 thread2 = new MyThread2(task);
		thread2.start();
	}
}
