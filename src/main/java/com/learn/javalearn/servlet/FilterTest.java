package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peng.lv on 2017/6/22.
 * Filter作为一种过滤器，既可以对客户端请求进行预处理，也可以对服务器响应进行后处理，是个典型的处理链
 * <filter>
 2         <filter-name>logfilter</filter-name>
 3         <filter-class>com.mine.test.LogFilter</filter-class>
 4     </filter>
 5     <filter-mapping>
 6         <filter-name>logfilter</filter-name>
 7         <url-pattern>/*</url-pattern> <!--配置过滤的范围   后缀符合即过滤  此处为全部过滤-->
 8     </filter-mapping>
 */
@WebFilter( filterName="LogFilter",servletNames="LogFilterServlet",initParams = {
        @WebInitParam(name = "encoding", value = "GBK"),
        @WebInitParam(name = "loginPage", value = "/user-login.jsp")}, urlPatterns = { "/online" })
public class FilterTest implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String ucenterId = request.getParameter("ucenterId");
        String userCode = request.getParameter("name");
        String username = request.getParameter("username");
        String siteCode = request.getParameter("siteCode");
        String password = request.getParameter("password");
        ServletContext sc = ((HttpServletRequest) servletRequest).getSession().getServletContext();

        filterChain.doFilter(servletRequest, servletResponse);//重点
    }

    @Override
    public void destroy() {

    }
}
