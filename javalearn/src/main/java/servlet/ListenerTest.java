package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Peng.lv on 2017/6/22.
 * 当Web应用运行时，Web应用内部会不断发生各种事件，如Web应用启动/停止、会话开始/结束、用户请求到达等。Listener可以监听这些事件的发生，并使我们可以参与到Web应用的生命周期中。
 与事件驱动程序一样，不同的事件需要注册不同的监听器来监听，常用的监听器有：
 - ServletContextListener：监听Web应用的启动/停止；
 - ServletRequestListener：监听用户请求；
 - HttpSessionListener：监听会话的开始/结束；
 - ServletContextAttributeListener：监听application范围内属性的变化；
 - ServletRequestAttributeListener：监听request范围内属性的变化；
 - HttpSessionAttributeListener：监听session范围内属性的变化。
 listener：监听器，从字面上可以看出listener主要用来监听只用。通过listener可以监听web服务器中某一个执行动作，并根据其要求作出相应的响应。（观察者设计模式）通俗的语言说就是在application，session，request三个对象创建消亡或者往其中添加修改删除属性时自动执行代码的功能组件。比如spring 的总监听器 会在服务器启动的时候实例化我们配置的bean对象 、 hibernate 的 session 的监听器会监听session的活动和生命周期，负责创建，关闭session等活动。
 Servlet的监听器Listener，它是实现了javax.servlet.ServletContextListener 接口的服务器端程序，它也是随web应用的启动而启动，只初始化一次，随web应用的停止而销毁。主要作用是： 做一些初始化的内容添加工作、设置一些基本的内容、比如一些参数或者是一些固定的对象等等。
 */
@WebListener
public class ListenerTest implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)  {
        ServletContext application=sce.getServletContext();
        Properties prop=new Properties();
        Enumeration<String> names=application.getInitParameterNames();
        while(names.hasMoreElements()) {
            String name=names.nextElement();
            prop.put(name, application.getInitParameter(name));
        }
        DBManager manager=DBManager.getInstance(prop);
        application.setAttribute("manager", manager);
    }

    public void contextDestroyed(ServletContextEvent sce)  {
        ServletContext application=sce.getServletContext();
        application.removeAttribute("manager");
    }
}
