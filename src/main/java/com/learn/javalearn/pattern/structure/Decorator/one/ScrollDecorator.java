package pattern.structure.Decorator.one;

//滚动条Decorator  
class ScrollDecorator extends Decorator{  
  public ScrollDecorator (VisualComponent component){  
  super(component);  
}  
@Override
public void draw(){  
  super.draw();  
  scrollTo();  
}  
public void scrollTo(){  
  System.out.println("TextArea scroll to…");  
}  
}  