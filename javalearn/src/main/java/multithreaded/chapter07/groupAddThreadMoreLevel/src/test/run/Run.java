package multithreaded.chapter07.groupAddThreadMoreLevel.src.test.run;

public class Run {

	public static void main(String[] args) {

		// ��main�������һ���߳���A��Ȼ�������A��������̶߳���Z
		// ����activeGroupCount()��activeCount()��ֵ���ǹ̶���
		// ��ϵͳ�л�����һ������
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup group = new ThreadGroup(mainGroup, "A");
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("runMethod!");
					Thread.sleep(10000);// �̱߳���������״̬�ſ����������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread newThread = new Thread(group, runnable);
		newThread.setName("Z");
		newThread.start();// �̱߳�������Ȼ��Ź鵽��A��
		// ///
		ThreadGroup[] listGroup = new ThreadGroup[Thread.currentThread()
				.getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(listGroup);
		System.out.println("main�߳����ж��ٸ����߳��飺" + listGroup.length + " ����Ϊ��"
				+ listGroup[0].getName());
		Thread[] listThread = new Thread[listGroup[0].activeCount()];
		listGroup[0].enumerate(listThread);
		System.out.println(listThread[0].getName());

	}

}
