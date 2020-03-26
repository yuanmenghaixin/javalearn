package pattern.structure.Composite;

import java.util.Iterator;

public class Leaf implements Component {
    @Override
	public Composite getComposite(){
        return null;  
    }  
      
    @Override
	public void operation(){  
        System.out.println("Leaf component operation");  
    }  
    @Override
	public void add(Component component){}
    @Override
	public void remove(Component component){}
    @Override
	public Iterator iter(){  
        return null;  
    }  

}
