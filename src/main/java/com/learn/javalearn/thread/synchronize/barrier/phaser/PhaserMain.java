package thread.synchronize.barrier.phaser;

/**
 * Created by Peng.lv on 2017/11/24.
 */
public class PhaserMain {
    public static void main(String[] args) {

        // 18. 创建 MyPhaser对象。
        MyPhaser phaser = new MyPhaser();
        // 19. 创建5个 Student 对象并使用register()方法在phaser中注册他们。
        MyPhaser.Student students[] = new MyPhaser.Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = phaser.new Student(phaser);
            phaser.register();
        }

        // 20. 创建5个线程来运行students并开始它们。
        Thread threads[] = new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        }

        // 21. 等待5个线程的终结。
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 22. 调用isTerminated()方法来写一条信息表明phaser是在termination状态。
        System.out.printf("Main: The phaser has finished: %s.\n",
                phaser.isTerminated());
    }
}
