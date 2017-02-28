package pattern.behaviour.Visitor;

//抽象元素  
interface IElement {
	public void accept(IVisitor visitor);
}
