package pattern.behaviour.Strategy.two;
/**
 * 減
 * @author Peng.lv
 *
 */
public class Minus extends AbstractCalculator implements ICalculator {  
  
    @Override  
    public int calculate(String exp) {  
        int arrayInt[] = split(exp,"-");  
        return arrayInt[0]-arrayInt[1];  
    }  
  
}
