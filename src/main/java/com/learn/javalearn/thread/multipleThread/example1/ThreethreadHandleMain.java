package thread.multipleThread.example1;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class ThreethreadHandleMain {
    public static void main(String[] args) throws InterruptedException
    {
        long startTime = System.currentTimeMillis();
        Count_i ci = new Count_i();
        Count_j cj = new Count_j();
        Count_k ck = new Count_k();
        Mul_thread_i aa = new Mul_thread_i(ci);
        Mul_thread_j bb = new Mul_thread_j(cj);
        Mul_thread_k cc = new Mul_thread_k(ck);

        aa.start();
        bb.start();
        cc.start();
        aa.join();
        bb.join();
        cc.join();


        System.out.println(ci.sum_i);
        System.out.println(cj.sum_j);
        System.out.println(ck.sum_k);
        long endTime = System.currentTimeMillis();
        System.out.println("run time:"+(endTime-startTime)+"ms");
    }
}
