package servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计在线人数
 *
 * Created by Peng.lv on 2017/6/22.
 *
 */
public class OnlineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 每当方法执行一次，在线人数+1
        // 1、获得当前的在线人数
        ServletContext context = se.getSession().getServletContext();
        int onlineNumber = (Integer) context.getAttribute("onlineNumber");
        onlineNumber++;
        // 保存回context范围
        context.setAttribute("onlineNumber", onlineNumber);
        System.out.println("当前" + onlineNumber + "人在线！");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 每当方法执行一次，在线人数-1
        // 1、获得当前的在线人数
        ServletContext context = se.getSession().getServletContext();
        int onlineNumber = (Integer) context.getAttribute("onlineNumber");
        onlineNumber--;
        // 保存回context范围
        context.setAttribute("onlineNumber", onlineNumber);
        System.out.println("有人离线了...");
        System.out.println("当前" + onlineNumber + "人在线！");
    }

}