package pattern.behaviour.Visitor;

//具体元素  
class ElementA implements IElement {
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public void operationA(){  
	    System.out.println("ElementA do operationA()……");  
	}
}