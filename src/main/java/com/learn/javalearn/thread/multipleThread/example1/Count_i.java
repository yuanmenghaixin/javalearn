package thread.multipleThread.example1;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class Count_i
{
    public int sum_i = 0;
    public synchronized void count()
    {
        for(int i = 0 ; i < 10000; i++)
        {
            sum_i += 1;
            /* 增加运行时间 后面同理*/
            for(int a = 0 ; a < 100000; a ++)
            {
                String s = "To cost some time";
                String[] ss = s.split(" ");
            }
        }
    }
}
