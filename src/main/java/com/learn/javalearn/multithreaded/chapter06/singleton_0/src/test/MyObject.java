package multithreaded.chapter06.singleton_0.src.test;

public class MyObject {

	// �������ط�ʽ==����ģʽ
	private static MyObject myObject = new MyObject();

	private MyObject() {
	}

	public static MyObject getInstance() {
		// �˴���汾Ϊ��������
		// �˰汾�����ȱ���ǲ���������ʵ������
		// ��ΪgetInstance()����û��ͬ��
		// �����п��ܳ��ַ��̰߳�ȫ����
		return myObject;
	}

}
