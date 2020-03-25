package multithreaded.chapter01.stopThrowLock.src.testpackage;

public class MyThread extends Thread {

	private testpackage.SynchronizedObject object;

	public MyThread(testpackage.SynchronizedObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		object.printString("b", "bb");
	}
}
