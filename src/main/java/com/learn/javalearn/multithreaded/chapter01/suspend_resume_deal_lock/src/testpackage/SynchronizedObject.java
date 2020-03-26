package multithreaded.chapter01.suspend_resume_deal_lock.src.testpackage;

public class SynchronizedObject {

	synchronized public void printString() {
		System.out.println("begin");
		if (Thread.currentThread().getName().equals("a")) {
			System.out.println("a�߳���Զ suspend�ˣ�");
			Thread.currentThread().suspend();
		}
		System.out.println("end");
	}

}
