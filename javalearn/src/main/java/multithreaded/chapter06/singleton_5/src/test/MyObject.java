package multithreaded.chapter06.singleton_5.src.test;

public class MyObject {

	private volatile static multithreaded.chapter06.singleton_0.src.test.MyObject myObject;

	private MyObject() {
	}

	// ʹ��˫���������������
	// ����֤�˲���Ҫͬ��������첽
	// �ֱ�֤�˵�����Ч��
	public static multithreaded.chapter06.singleton_0.src.test.MyObject getInstance() {
		try {
			if (myObject != null) {
			} else {
				// ģ���ڴ�������֮ǰ��һЩ׼���ԵĹ���
				Thread.sleep(3000);
				synchronized (multithreaded.chapter06.singleton_0.src.test.MyObject.class) {
					if (myObject == null) {
						myObject = new multithreaded.chapter06.singleton_0.src.test.MyObject();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return myObject;
	}
	// �˰汾�Ĵ����Ϊ��
	// ˫�ؼ��Double-Check Locking

}
