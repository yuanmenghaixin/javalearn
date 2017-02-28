package pattern.behaviour.Visitor;

//具体访问者  
class MyVisitor implements IVisitor {
	@Override
	public void visit(ElementA element) {
		element.operationA();
	}

	@Override
	public void visit(ElementB element) {
		element.operationB();
	}

	@Override
	public void visit(ElementC element) {
		element.operationC();
	}
}
