package multithreaded.chapter06.singleton_3.src.test;

public class MyObject {

	private static multithreaded.chapter06.singleton_0.src.test.MyObject myObject;

	private MyObject() {
	}

	public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		try {
			if (myObject != null) {
			} else {
				// ģ���ڴ�������֮ǰ��һЩ׼���ԵĹ���
				Thread.sleep(3000);
				// ʹ��synchronized (MyObject.class)
				// ��Ȼ���ִ��뱻����
				// �������з��̰߳�ȫ����
				synchronized (multithreaded.chapter06.singleton_0.src.test.MyObject.class) {
					myObject = new multithreaded.chapter06.singleton_0.src.test.MyObject();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return myObject;
	}

}
