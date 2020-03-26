package multithreaded.chapter06.singleton_2_2.src.test;

public class MyObject {

	private static multithreaded.chapter06.singleton_0.src.test.MyObject myObject;

	private MyObject() {
	}

	public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		try {
			// ����д����ͬ�ڣ�
			// synchronized public static MyObject getInstance()
			// ��д����Ч��һ���ܵͣ�ȫ�����뱻����
			synchronized (multithreaded.chapter06.singleton_0.src.test.MyObject.class) {
				if (myObject != null) {
				} else {
					// ģ���ڴ�������֮ǰ��һЩ׼���ԵĹ���
					Thread.sleep(3000);

					myObject = new multithreaded.chapter06.singleton_0.src.test.MyObject();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return myObject;
	}

}
