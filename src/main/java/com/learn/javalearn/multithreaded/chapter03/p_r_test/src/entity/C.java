package multithreaded.chapter03.p_r_test.src.entity;

//������
public class C {

	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals("")) {
					lock.wait();
				}
				System.out.println("get��ֵ��" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
