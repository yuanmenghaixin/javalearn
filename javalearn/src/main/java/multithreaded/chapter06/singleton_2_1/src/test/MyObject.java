package multithreaded.chapter06.singleton_2_1.src.test;

public class MyObject {

	private static multithreaded.chapter06.singleton_0.src.test.MyObject myObject;

	private MyObject() {
	}

	// ����ͬ������Ч��̫����
	// ��������������
	synchronized public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		try {
			if (myObject != null) {
			} else {
				// ģ���ڴ�������֮ǰ��һЩ׼���ԵĹ���
				Thread.sleep(3000);
				myObject = new multithreaded.chapter06.singleton_0.src.test.MyObject();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return myObject;
	}

}
