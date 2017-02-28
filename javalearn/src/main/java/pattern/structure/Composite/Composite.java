package pattern.structure.Composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite  implements Component {
	  private List< Component> components = new ArrayList< Component>();  
	  @Override
	public Composite getComposite(){  
	    return this;  
	}  
	@Override
	public void operation(){  
	    Iterator<Component> iter = iter ();  
	    while(iter.hasNext()){  
	    iter.next().operation();  
	}  
	}  
	  
	    @Override
		public void add(Component component){  
	    components.add(component);  
	}  
	    @Override
		public void remove(Component component){  
	    components.remove(component);  
	}  
	    @Override
		public Iterator<Component> iter(){  
	    return components.iterator();  
	}  
	
}