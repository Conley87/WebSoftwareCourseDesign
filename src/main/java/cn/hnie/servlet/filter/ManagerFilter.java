package cn.hnie.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", value = "/manager/*")
public class ManagerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        String adminFlag = (String) hsr.getSession().getAttribute("adminFlag");
        if (adminFlag != null && adminFlag.equals("true"))
            chain.doFilter(req, resp);
        else
            httpServletResponse.sendRedirect("/CourseDesign/login.html");
    }
}
