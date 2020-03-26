package multithreaded.chapter03.ThreadLocal11.src.test;

public class Run {
	public static ThreadLocal tl = new ThreadLocal();

	public static void main(String[] args) {
		if (tl.get() == null) {
			System.out.println("��δ�Ź�ֵ");
			tl.set("�ҵ�ֵ");
		}
		System.out.println(tl.get());
		System.out.println(tl.get());
	}

}
