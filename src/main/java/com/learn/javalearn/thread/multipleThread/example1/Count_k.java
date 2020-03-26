package thread.multipleThread.example1;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class Count_k{
    public int sum_k = 0;
    public synchronized void count()
    {
        for(int k = 0 ; k < 10000; k++)
        {
            sum_k += 3;
            for(int a = 0 ; a < 100000; a ++)
            {
                String s = "To cost some time";
                String[] ss = s.split(" ");
            }
        }
    }
}
