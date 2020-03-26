package multithreaded.chapter02.t5.src.mythread;

import multithreaded.chapter02.t5.src.commonutils.CommonUtils;

import multithreaded.chapter02.t5.src.mytask.Task;

public class MyThread2 extends Thread {

	private Task task;

	public MyThread2(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime2 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime2 = System.currentTimeMillis();
	}

}
