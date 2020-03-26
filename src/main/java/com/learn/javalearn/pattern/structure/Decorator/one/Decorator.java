package pattern.structure.Decorator.one;
//抽象Decorator  
public abstract class Decorator implements VisualComponent {  
    protected VisualComponent component;  
    public Decorator(VisualComponent component){  
    this.component = component;  
} 
    @Override
	public void draw(){  
        component.draw();  
    }  
 }
