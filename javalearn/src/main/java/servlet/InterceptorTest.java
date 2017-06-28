package servlet;

/**
 * Created by Peng.lv on 2017/6/22.
 * interceptor：是在面向切面编程的，就是在你的service或者一个方法，前调用一个方法，或者在方法后调用一个方法，是基于JAVA的反射机制。比如动态代理就是拦截器的简单实现，在你调用方法前打印出字符串（或者做其它业务逻辑的操作），也可以在你调用方法后打印出字符串，甚至在你抛出异常的时候做业务逻辑的操作。
 servlet、filter、listener是配置到web.xml中（web.xml 的加载顺序是：context-param -> listener -> filter -> servlet ），interceptor不配置到web.xml中，struts的拦截器配置到struts.xml中。spring的拦截器配置到spring.xml中。
 */
public class InterceptorTest {
}
