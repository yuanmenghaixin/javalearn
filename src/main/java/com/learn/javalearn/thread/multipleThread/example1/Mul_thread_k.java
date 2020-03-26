package thread.multipleThread.example1;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class Mul_thread_k extends Thread
{
    public Count_k c_k;
    public Mul_thread_k(Count_k acc)
    {
        this.c_k = acc;
    }
    @Override
    public void run()
    {
        c_k.count();
    }
}
