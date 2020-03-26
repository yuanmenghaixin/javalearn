package thread.multipleThread.example1;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class Mul_thread_j extends Thread
{
    public Count_j c_j;
    public Mul_thread_j(Count_j acc)
    {
        this.c_j = acc;
    }
    @Override
    public void run()
    {
        c_j.count();
    }
}
