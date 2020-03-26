package multithreaded.chapter06.singleton_7.src.test;

public class MyObject {

	// �ڲ��෽ʽ
	private static class MyObjectHandler {
		private static multithreaded.chapter06.singleton_0.src.test.MyObject myObject = new multithreaded.chapter06.singleton_0.src.test.MyObject();
	}

	private MyObject() {
	}

	public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		return MyObjectHandler.myObject;
	}

}
