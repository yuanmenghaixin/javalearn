package multithreaded.chapter02.t7.src.mythread;

import multithreaded.chapter02.t7.src.mytask.Task;

public class MyThread2 extends Thread {

	private Task task;

	public MyThread2(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		task.doLongTimeTask();
	}

}
