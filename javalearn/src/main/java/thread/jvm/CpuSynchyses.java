package thread.jvm;

/**
 * Created by Peng.lv on 2017/9/29.
 * Cpu乱序功能验证测试
 */
public class CpuSynchyses {
    int x=0;
    int y=0;
    int a=0;
    int b=0;

    public static void doTest(int i){
        CpuSynchyses cpuSynchyses= new CpuSynchyses();
        //Thread one =new Thread(()->{cpuSynchyses.a=1;cpuSynchyses.x=cpuSynchyses.b;});
        //Thread other =new Thread(()->{cpuSynchyses.a=1;cpuSynchyses.x=cpuSynchyses.b;});
    }

}
