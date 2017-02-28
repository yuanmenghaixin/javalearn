package pattern.behaviour.Visitor;

class ElementB implements IElement {
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

public void operationB(){  
    System.out.println("ElementB do operationB()……");  
}
}