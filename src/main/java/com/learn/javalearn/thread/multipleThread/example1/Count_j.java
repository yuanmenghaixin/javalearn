package thread.multipleThread.example1;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class Count_j {
    public int sum_j = 0;
    public synchronized void count()
    {
        for(int j = 0 ; j < 10000; j++)
        {
            sum_j += 2;
            for(int a = 0 ; a < 100000; a ++)
            {
                String s = "To cost some time";
                String[] ss = s.split(" ");
            }
        }
    }
}
