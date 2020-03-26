package multithreaded.chapter06.singleton_1.src.test;

public class MyObject {

	private static multithreaded.chapter06.singleton_0.src.test.MyObject myObject;

	private MyObject() {
	}

	public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		// �ӳټ���
		if (myObject != null) {
		} else {
			myObject = new multithreaded.chapter06.singleton_0.src.test.MyObject();
		}
		return myObject;
	}

}
