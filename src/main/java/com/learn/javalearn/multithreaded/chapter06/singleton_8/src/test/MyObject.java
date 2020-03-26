package multithreaded.chapter06.singleton_8.src.test;


public class MyObject {

	private static multithreaded.chapter06.singleton_0.src.test.MyObject instance = null;

	private MyObject() {
	}

	static {
		instance = new multithreaded.chapter06.singleton_0.src.test.MyObject();
	}

	public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		return instance;
	}

}
