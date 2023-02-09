package cn.hnie.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//TODO(设置该Filter拦截的资源)
@WebFilter(filterName = "TeacherFilter",value = "/teacher/*")
public class TeacherFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse hsrp = (HttpServletResponse) response;
        String TeacherFlag = (String) hsr.getSession().getAttribute("TeacherFlag");
        if (TeacherFlag != null && TeacherFlag.equals("true"))
            chain.doFilter(request, response);
        else
            hsrp.sendRedirect("/teacher.html");
    }
}
