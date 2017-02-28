package pattern.behaviour.Command.two;

//客户端    
public class Client {
	public static void main(String[] args) {
		// 客户端创建命令接受者
		Receiver receiver = new Receiver();
		// 客户端创建具体命令，并指定命令接受者
		Command command = new ConcreteCommand(receiver);
		// 客户端创建请求者，并给请求者指定具体命令
		Invoker invoker = new Invoker(command);
		// 命令请求者发出命令请求
		invoker.action();
	}
}
