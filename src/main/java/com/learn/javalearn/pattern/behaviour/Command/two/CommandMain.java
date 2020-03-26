package pattern.behaviour.Command.two;

/**
 * Command命令设计模式将一个请求封装成一个对象，从而使你可用不同的请求对客户进行操作。Command命令设计模式是对命令的封装。
 * 命令模式把发出命令的责任和执行命令的责任分割开，委派给不同的对象。每一个命令都是一个操作，命令请求发出请求要求执行一个操作；命令接受方收到请求，并执行操作
 * 。命令模式允许命令请求方和命令接收方独立开来，使得命令请求方不必
 * 知道命令接收方的接口，更不必知道请求是怎么被接收，以及操作是否被执行，何时被执行，以及是怎么被执行的。
 * 
 * @author Peng.lv
 *
 */
public class CommandMain {
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
