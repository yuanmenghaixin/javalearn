package thread.methods;

/**
 * Created by Peng.lv on 2018/5/17.
 */
public class GetIdMain {
    public static void main(String[] args) {
        Thread t= Thread.currentThread();
        System.out.println(t.getName()+" "+t.getId());
    }
}
