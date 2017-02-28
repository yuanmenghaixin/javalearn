package pattern.create.Factory.FactoryAbstract.two;

public class IOSSkinFactory implements SkinFactory {  
    public Style getStyle() {  
        return new IOSStyle();  
    }  
  
    public Color getColor() {  
        return new IOSColor();  
    }  
}
