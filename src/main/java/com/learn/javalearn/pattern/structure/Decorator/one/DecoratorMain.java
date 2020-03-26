package pattern.structure.Decorator.one;
/**
 * Decorator装饰设计模式和Proxy代理模式的区别：
Decorator装饰设计模式和Proxy代理模式非常类似，都可以对目标对象做一些动态改变，以致于很多初学者分不清楚Decorator装饰设计模式和Proxy代理模式，个人觉得二者简单区别如下：
(1).Proxy代理模式中，客户端不直接调用服务端程序，而是通过一个代理对象来调用服务端程序，类似一个请求转发的作用。
(2). Decorator装饰设计模式中，被装饰对象可以不用添加任何装饰而直接使用，也可以通过装饰器的包装动态增强功能。
JDK中装饰者模式的应用：
•java.io包
•java.util.Collections#synchronizedList(List)
•AWT和Swing图形组件
 * @author Peng.lv
 *
 */
//装饰模式（Decorator）类似spring AOP切面编程
public class DecoratorMain {
	public static void main(String[] args){  
	    //画一个普通的TextArea  
	    TextArea textArea = new TextArea();  
	    textArea.draw();  
	    //画一个带滚动条的TextArea  
	    ScrollDecorator scroll = new ScrollDecorator(new TextArea());  
	    scroll.draw();  
	    //画一个带边框的TextArea  
	    BorderDecorator border = new BorderDecorator(new TextArea());  
	    border.draw();  
	    //画一个既带边框又带滚动条的TextArea  
	    BorderDecorator border2 = new BorderDecorator(new ScrollDecorator(new TextArea()));  
	    border2.draw();  
	}  
}
