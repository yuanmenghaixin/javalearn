package pattern.structure.Decorator.two;
/**
 * 装饰者和被装饰者都实现了Sourceable，Decorator装饰者，Source被装饰者
 * @author Peng.lv
 *
 */
public class Decorator implements Sourceable {  
  
    private Sourceable source;  
    public Decorator(Sourceable source){  
        super();  
        this.source = source;  
    }  
    @Override  
    public void method() {  
        System.out.println("before decorator!");  
        source.method();  
        System.out.println("after decorator!");  
    }  
}
