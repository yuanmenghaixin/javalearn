package networkCode.chapter3.threadReturnValue.callable;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/3/6.
 */
public class FindMaxNumber implements Callable <Integer>{
    private int[] data;
    private int start;
    private int end;

    FindMaxNumber(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public Integer call() throws Exception {
        int max=Integer.MIN_VALUE;
       for(int i=start;i<end;i++){
           if(data[i]>max) max=data[i];
        }
        return max;
    }
}
