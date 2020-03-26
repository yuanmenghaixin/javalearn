package pattern.create.Factory.FactoryAbstract.two;
/**
 * 皮肤类 
 * @author Peng.lv
 *
 */
public class Skin {
	private SkinFactory skinFactory;  
	  
    public Skin(SkinFactory factory) {  
        setSkinFactory(factory);  
    }  
  
    public void setSkinFactory(SkinFactory factory) {  
        this.skinFactory = factory;  
    }  
  
    public void showSkin() {  
        System.out.println("Style=" + skinFactory.getStyle().showStyle()  
                + ", color=" + skinFactory.getColor().showColor());  
    }  
}
