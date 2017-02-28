package pattern.behaviour.Visitor;

class ElementC implements IElement {
    public void accept(IVisitor visitor){
    visitor.visit(this);  
}  
public void operationC(){  
    System.out.println("ElementC do operationC()……");  
}  
}  
