package thread.example;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Java天生多线程
 * 一个Java程序从main()方法开始执行，然后按照既定的代码逻辑执行，看似没有其他线程
 参与，但实际上Java程序天生就是多线程程序，因为执行main()方法的是一个名称为main的线
 程。下面使用JMX来查看一个普通的Java程序包含哪些线程，如代码清单4-1所示。
 [4] Signal Dispatcher　 // 分发处理发送给JVM信号的线程
 [3] Finalizer　　　　 // 调用对象finalize方法的线程
 [2] Reference Handler // 清除Reference的线程
 [1] main　 　　　　 // main线程，用户程序入口
 * Created by Peng.lv on 2017/12/7.
 */
public class MultiThread {
    public static void main(String[] args) {
// 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
// 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
// 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
                    getThreadName());
        }
    }
}
