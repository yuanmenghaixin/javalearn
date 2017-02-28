package pattern.structure.Composite;

import java.util.Iterator;

public interface Component {
	public void operation();  
	Composite getComposite();  
    public void add(Component component);  
    public void remove(Component component);  
    public Iterator iter();  
}
