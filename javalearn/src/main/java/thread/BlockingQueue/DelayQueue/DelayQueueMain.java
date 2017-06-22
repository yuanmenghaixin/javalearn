package thread.BlockingQueue.DelayQueue;

/**
 * Created by Peng.lv on 2017/6/22.
 * DelayQueue：一个使用优先级队列实现的无界阻塞队列。
 * DelayQueue是一个支持延时获取元素的无界阻塞队列。队列使用PriorityQueue来实现。队列中的元素必须实现Delayed接口，在创建元素时可以指定多久才能从队列中获取当前元素。只有在延迟期满时才能从队列中提取元素。我们可以将DelayQueue运用在以下应用场景：
 缓存系统的设计：可以用DelayQueue保存缓存元素的有效期，使用一个线程循环查询DelayQueue，一旦能从DelayQueue中获取元素时，表示缓存有效期到了。
 定时任务调度。使用DelayQueue保存当天将会执行的任务和执行时间，一旦从DelayQueue中获取到任务就开始执行，从比如TimerQueue就是使用DelayQueue实现的。
 队列中的Delayed必须实现compareTo来指定元素的顺序。比如让延时时间最长的放在队列的末尾。实现代码如下：
 public int compareTo(Delayed other) {
 if (other == this) // compare zero ONLY if same object
 return 0;
 if (other instanceof ScheduledFutureTask) {
 ScheduledFutureTask x = (ScheduledFutureTask)other;
 long diff = time - x.time;
 if (diff < 0)
 return -1;
 else if (diff > 0)
 return 1;
 else if (sequenceNumber < x.sequenceNumber)
 return -1;
 else
 return 1;
 }
 long d = (getDelay(TimeUnit.NANOSECONDS) -
 other.getDelay(TimeUnit.NANOSECONDS));
 return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
 }
 如何实现Delayed接口
 我们可以参考ScheduledThreadPoolExecutor里ScheduledFutureTask类。这个类实现了Delayed接口。首先：在对象创建的时候，使用time记录前对象什么时候可以使用，代码如下：
 ScheduledFutureTask(Runnable r, V result, long ns, long period) {
 super(r, result);
 this.time = ns;
 this.period = period;
 this.sequenceNumber = sequencer.getAndIncrement();
 }
 然后使用getDelay可以查询当前元素还需要延时多久，代码如下：
 public long getDelay(TimeUnit unit) {
 return unit.convert(time - now(), TimeUnit.NANOSECONDS);
 }
 通过构造函数可以看出延迟时间参数ns的单位是纳秒，自己设计的时候最好使用纳秒，因为getDelay时可以指定任意单位，一旦以纳秒作为单位，而延时的时间又精确不到纳秒就麻烦了。使用时请注意当time小于当前时间时，getDelay会返回负数。
 如何实现延时队列
 延时队列的实现很简单，当消费者从队列里获取元素时，如果元素没有达到延时时间，就阻塞当前线程。
 long delay = first.getDelay(TimeUnit.NANOSECONDS);
 if (delay <= 0)
 return q.poll();
 else if (leader != null)
 available.await();
 */
public class DelayQueueMain {
}
