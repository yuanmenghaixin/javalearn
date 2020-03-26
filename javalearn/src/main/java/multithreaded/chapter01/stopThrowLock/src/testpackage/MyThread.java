package multithreaded.chapter01.stopThrowLock.src.testpackage;

public class MyThread extends Thread {

	private  multithreaded.chapter01.stopThrowLock.src.testpackage.SynchronizedObject object;

	public MyThread( multithreaded.chapter01.stopThrowLock.src.testpackage.SynchronizedObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		object.printString("b", "bb");
	}
}
