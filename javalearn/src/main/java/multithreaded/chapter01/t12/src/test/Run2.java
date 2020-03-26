package multithreaded.chapter01.t12.src.test;

public class Run2 {
	public static void main(String[] args) {
		Thread.currentThread().interrupt();
		System.out.println("�Ƿ�ֹͣ1��=" + Thread.interrupted());
		System.out.println("�Ƿ�ֹͣ2��=" + Thread.interrupted());
		System.out.println("end!");
	}
}
