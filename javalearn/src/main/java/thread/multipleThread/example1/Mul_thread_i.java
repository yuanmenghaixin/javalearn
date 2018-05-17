package thread.multipleThread.example1;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class Mul_thread_i extends Thread
{
    public Count_i c_i;
    public Mul_thread_i(Count_i acc)
    {
        this.c_i = acc;
    }
    @Override
    public void run()
    {
        c_i.count();
    }
}
