package pattern.create.Factory.FactoryAbstract.two;
/**
 * Android皮肤工厂 
 * @author Peng.lv
 *
 */
public class AndroidSkinFactory  implements SkinFactory {  
    public Style getStyle() {  
        return new AndroidStyle();  
    }  
  
    public Color getColor() {  
        return new AndroidColor();  
    }  

}
