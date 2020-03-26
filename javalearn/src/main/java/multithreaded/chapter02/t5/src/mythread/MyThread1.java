package multithreaded.chapter02.t5.src.mythread;

import multithreaded.chapter02.t5.src.commonutils.CommonUtils;

import multithreaded.chapter02.t5.src.mytask.Task;

public class MyThread1 extends Thread {

	private Task task;

	public MyThread1(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime1 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime1 = System.currentTimeMillis();
	}

}
