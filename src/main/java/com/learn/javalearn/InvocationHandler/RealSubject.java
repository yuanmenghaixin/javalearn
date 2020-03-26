package lang.reflect.InvocationHandler;

/**
 * Created by Peng.lv on 2018/4/26.
 */
//真实角色：实现了Subject的request()方法
public class RealSubject implements Subject{

    @Override
    public void request(){
        System.out.println("From real subject.");
    }
}
