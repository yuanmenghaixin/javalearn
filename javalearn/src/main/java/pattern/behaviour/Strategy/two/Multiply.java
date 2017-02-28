package pattern.behaviour.Strategy.two;
/**
 * 乘
 * @author Peng.lv
 *
 */
public class Multiply extends AbstractCalculator implements ICalculator {  
  
    @Override  
    public int calculate(String exp) {  
        int arrayInt[] = split(exp,"\\*");  
        return arrayInt[0]*arrayInt[1];  
    }  

}
