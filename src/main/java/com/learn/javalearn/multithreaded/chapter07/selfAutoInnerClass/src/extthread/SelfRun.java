package multithreaded.chapter07.selfAutoInnerClass.src.extthread;

public class SelfRun {
	private Thread selfThread;
	private volatile boolean isContinueRun = true;

	public SelfRun() {
		isContinueRun = true;
		Runnable runnableRef = new Runnable() {
			@Override
			public void run() {
				runTask();
			}
		};
		selfThread = new Thread(runnableRef);
		selfThread.start();
	}

	private void runTask() {
		while (isContinueRun) {
			try {
				System.out.println("�������У�" + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (InterruptedException x) {
				x.printStackTrace();
			}
		}
	}

	public void stopRun() {
		isContinueRun = false;
	}

}