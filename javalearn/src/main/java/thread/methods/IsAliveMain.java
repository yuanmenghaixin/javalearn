package thread.methods;

/**
 * Created by Peng.lv on 2018/5/17.
 */
public class IsAliveMain {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        System.out.println("begin =="+myThread.isAlive());
        myThread.start();
        System.out.println("end =="+myThread.isAlive());
    }

    public static class MyThread  extends Thread{
        @Override
        public void run() {
            System.out.println("run="+this.isAlive());
        }
    }
}
