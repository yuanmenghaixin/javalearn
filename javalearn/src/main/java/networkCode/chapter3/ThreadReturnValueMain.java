package networkCode.chapter3;

/**
 * 获取不到线程的返回值.
 */
public class ThreadReturnValueMain {
    public static void main(String[] args){
        ThreadReturnValue t =new ThreadReturnValue("123");
        t.start();
       System.out.print(t.getValue2());
    }
}
