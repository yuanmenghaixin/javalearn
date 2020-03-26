package thread.lock.semaphore;

/**
 * Semaphore信号量的使用：
 Semaphore使用时需要先构建一个参数来指定共享资源的数量，Semaphore构造完成后即是获取Semaphore、共享资源使用完毕后释放Semaphore。
 *Semaphore除了控制资源的多个副本的并发访问控制，也可以使用二进制信号量来实现类似synchronized关键字和Lock锁的并发访问控制功能
 *  Created by Peng.lv on 2017/11/20.
 */
public class ResourceUserSemaphoreMain implements Runnable{
    private ResourceManage resourceManage;
    private int userId;
    public ResourceUserSemaphoreMain(ResourceManage resourceManage, int userId) {
        this.resourceManage = resourceManage;
        this.userId = userId;
    }
    @Override
    public void run(){
        System.out.print("userId:"+userId+"准备使用资源...\n");
        resourceManage.useResource(userId);
        System.out.print("userId:"+userId+"使用资源完毕...\n");
    }

    public static void main(String[] args){
        ResourceManage resourceManage = new ResourceManage();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ResourceUserSemaphoreMain(resourceManage,i));//创建多个资源使用者
            threads[i] = thread;
        }
        for(int i = 0; i < 100; i++){
            Thread thread = threads[i];
            try {
                thread.start();//启动线程
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
