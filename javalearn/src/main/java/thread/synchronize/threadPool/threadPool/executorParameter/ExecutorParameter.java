package thread.synchronize.threadPool.threadPool.executorParameter;

/**
 * Created by Peng.lv on 2017/10/13.
 */
public class ExecutorParameter {
    /**
     * public ThreadPoolExecutor(int corePoolSize,
     int maximumPoolSize,
     long keepAliveTime,
     TimeUnit unit,
     BlockingQueue<Runnable> workQueue,
     ThreadFactory threadFactory,
     RejectedExecutionHandler handler)
     corePoolSize    线程池维护线程的最少数量
     maximumPoolSize  线程池维护线程的最大数量
     keepAliveTime   线程池维护线程所允许的空闲时间 ，所以如果任务很多，并且每个任务执行的时间比较短，可以适当调大这个参数来提高线程的利用率。
     unit     keepAliveTime 参数的单位，可选的单位：天（DAYS），小时（HOURS），分钟（MINUTES），毫秒(MILLISECONDS)，微秒(MICROSECONDS)和纳秒(NANOSECONDS)
     workQueue    任务队列，用来存放我们所定义的任务处理线程，BlockingQueue是一种带锁的阻塞队列，我们将在后面专门讲解这种数据结构，BlockingQueue有四种选择：（1）ArrayBlockingQueue，是一种基于数组的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行操作；（2）LinkedBlockingQueue，是一个基于链表的阻塞队列，此队列也按FIFO （先进先出）对元素进行操作，吞吐量通常要高于ArrayBlockingQueue， Executors.newFixedThreadPool()使用了这种队列；（3）SynchronousQueue；是一种不存储元素的阻塞队列，每个插入操作必须等另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，Executors.newCachedThreadPool使用了这个队列；（4）PriorityBlockingQueue，是一种具有优先权的阻塞队列，优先级大的任务可以先执行，用户由此可以控制任务的执行顺序。这四种阻塞队列都有自己的使用场景，用户可以根据需要自己决定使用。
     threadFactory   创建新线程时使用的工厂，threadFactory有两种选择：（1）DefaultThreadFactory，将创建一个同线程组且默认优先级的线程；（2）PrivilegedThreadFactory，使用访问权限创建一个权限控制的线程。ThreadPoolExecutor默认采用DefaultThreadFactory
     handler  由于超出线程范围和队列容量而使执行被阻塞时所使用的处理策略，handler有四个选择：（1）ThreadPoolExecutor.AbortPolicy()，将抛出RejectedExecutionException异常；（2）ThreadPoolExecutor.CallerRunsPolicy()，将重试添加当前的任务，重复调用execute()方法；（3）ThreadPoolExecutor.DiscardOldestPolicy()，将抛弃旧任务；（4）ThreadPoolExecutor.DiscardPolicy，将直接抛弃任务。ThreadPoolExecutor默认采用AbortPolicy。
     一个任务通过execute(Runnable)方法被添加到线程池，任务必须是一个 Runnable类型的对象，任务的执行方法就是调用Runnable类型对象的run()方法。当一个任务通过execute(Runnable)方法欲添加到线程池时，会做一下几步：
     1. 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
     2. 如果此时线程池中的数量大于等于corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
     3. 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理添加的任务。
     4. 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。也就是处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
     5. 当线程池中的线程数量大于corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
     读者可以参考下面的源代码，分析execute函数执行的流程：
     public void execute(Runnable command) {
     if (command == null)
     throw new NullPointerException();
     if (poolSize >= corePoolSize || !addIfUnderCorePoolSize(command)) {
     if (runState == RUNNING && workQueue.offer(command)) {
     if (runState != RUNNING || poolSize == 0)
     ensureQueuedTaskHandled(command);
     }
     else if (!addIfUnderMaximumPoolSize(command))
     reject(command); // 执行handler策略
     }
     }
     当数量少于corePoolSize时的主要流程：
     private boolean addIfUnderCorePoolSize(Runnable firstTask) {
     Thread t = null;
     final ReentrantLock mainLock = this.mainLock;
     mainLock.lock();
     try {
     if (poolSize < corePoolSize && runState == RUNNING)
     t = addThread(firstTask); //创建新线程
     } finally {
     mainLock.unlock();
     }
     if (t == null)
     return false;
     t.start();
     return true;
     }
     当数量大于corePoolSize，小于maximumPoolSize，且阻塞队列不能存储任务时，执行的主要流程：
     private boolean addIfUnderMaximumPoolSize(Runnable firstTask) {
     Thread t = null;
     final ReentrantLock mainLock = this.mainLock;
     mainLock.lock();
     try {
     if (poolSize < maximumPoolSize && runState == RUNNING)
     t = addThread(firstTask);
     } finally {
     mainLock.unlock();
     }
     if (t == null)
     return false;
     t.start();
     return true;

     }

     如果想在多线程环境中定期执行去执行任务，或者做一些其他事情，用户可以通过Timer来实现，但是Timer有几种缺陷：（1）Timer是基于绝对时间的，容易受系统时钟的影响；（2）imer只新建了一个线程来执行所有的TimeTask，所有TimeTask可能会相关影响；（3）Timer不会捕获TimerTask的异常，只是简单地停止。这样势必会影响其他TimeTask的执行。JDK提供了一种定时功能的线程池：ScheduledThreadPoolExecutor，它继承了ThreadPoolExecutor，并且实现了ScheduledExecutorService接口，此接口有如下几个方法：
     public ScheduledFuture<?> schedule(Runnable command,
     long delay, TimeUnit unit);
     创建并执行在给定延迟后启用的一次性操作
     public <V> ScheduledFuture<V> schedule(Callable<V> callable,
     long delay, TimeUnit unit);
     创建并执行在给定延迟后启用的一次性操作
     public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
     long initialDelay,
     long period,
     TimeUnit unit);
     创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是经过period 后开始执行，即在 initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推。如果任务的任何一个执行遇到异常，则后续执行都会被取消。否则，只能通过执行程序的取消或终止方法来终止该任务。如果此任务的任何一个执行要花费比其周期更长的时间，则将推迟后续执行，但不会同时执行。
     public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
     long initialDelay,
     long delay,
     TimeUnit unit);
     创建并执行一个在给定初始延迟后首次启用的定期操作，随后在每一次执行终止和下一次执行开始之间都存在给定的延迟。如果任务的任一执行遇到异常，就会取消后续执行。否则，只能通过执行程序的取消或终止方法来终止该任务。
     ScheduledThreadPoolExecutor也提供了几个构造函数，下面列出的是其中最简单的一个，只有corePoolSize一个参数。ScheduledThreadPoolExecutor的构造函数仅做的一件事就是调用ThreadPoolExecutor的构造函数，它使用一种带有延时标记的等待队列DelayedWorkQueue。DelayedWorkQueue内部使用concurrent包里的DelayQueue，DelayQueue是一个无界的BlockingQueue，用于放置延时Delayed接口的对象，对象只能在其到期时才能从队列中取走，我们将在专门讲解这种数据结构。
     public ScheduledThreadPoolExecutor(int corePoolSize) {
     super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
     new DelayedWorkQueue());

     }



     要配置一个线程池相对比较复杂，需要了解相关的参数，尤其是对于线程池的原理不是很清楚的情况下，很有可能配置的线程池不是较优的，因此在Executors类里面提供了一些静态工厂，生成一些常用的线程池：
     public static ExecutorService newSingleThreadExecutor()
     创建仅有一个线程工作的线程池，相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么将创建有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
     public static ExecutorService newCachedThreadPool()
     创建一个缓存线程池，如果线程池的大小超过了任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又动态添加新线程来处理任务。此线程池没有对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）所能够创建的最大线程大小。
     public static ExecutorService newFixedThreadPool(int nThreads)
     创建指定大小的线程池。每次提交一个任务就创建一个线程，直到线程数量达到线程池的最大值。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
     public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
     类似于newCachedThreadPool，创建一个缓存线程池，此线程池还支持定时以及周期性执行任务。
     public static ScheduledExecutorService newSingleThreadScheduledExecutor()
     类似于newSingleThreadExecutor，创建一个单线程的线程池，此线程池还支持定时以及周期性执行任务。
     下面用两个例子介绍线程池的使用方法，第一个例子会创建一个固定大小的线程池，第二个例子会创建基于时间线程池。

     第一个例子
     */
}