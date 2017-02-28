package pattern.structure.Decorator.two;
/**
 * 被装饰者
 * @author Peng.lv
 *
 */
public class Source  implements Sourceable {
    @Override  
    public void method() {  
        System.out.println("the original method!");  
    }  

}
