package cn.hnie.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对student资源的拦截处理，只有成功登录才能访问资源
 */
//TODO(设置该Filter该拦截的资源)
@WebFilter(filterName = "StudentFilter", value = "/student/*")
public class StudentFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse hsrp = (HttpServletResponse) response;
        String studentFlag = (String) hsr.getSession().getAttribute("StudentFlag");
        if (studentFlag != null && studentFlag.equals("true"))
            chain.doFilter(request, response);
        else
            hsrp.sendRedirect("/student.html");

    }
}
