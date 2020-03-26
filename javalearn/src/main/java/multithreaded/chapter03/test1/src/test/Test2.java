package multithreaded.chapter03.test1.src.test;

public class Test2 {

	public static void main(String[] args) {
		try {
			String lock = new String();
			System.out.println("syn����");
			synchronized (lock) {
				System.out.println("syn��һ��");
				lock.wait();
				System.out.println("wait�µĴ��룡");
			}
			System.out.println("syn����Ĵ���");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
