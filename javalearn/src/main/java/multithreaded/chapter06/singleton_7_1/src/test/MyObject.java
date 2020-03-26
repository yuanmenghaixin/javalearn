package test;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MyObject implements Serializable {

	private static final long serialVersionUID = 888L;

	// �ڲ��෽ʽ
	private static class MyObjectHandler {
		private static final multithreaded.chapter06.singleton_0.src.test.MyObject myObject = new multithreaded.chapter06.singleton_0.src.test.MyObject();
	}

	private MyObject() {
	}

	public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		return MyObjectHandler.myObject;
	}

	protected Object readResolve() throws ObjectStreamException {
		System.out.println("������readResolve������");
		return MyObjectHandler.myObject;
	}

}
