package cn.hnie.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//TODO(设置该Filter拦截的资源)
@WebFilter(filterName = "AdminFilter", value = "/admin/*")
public class ManagerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) req;
        String adminFlag = (String) hsr.getSession().getAttribute("adminFlag");
        if (adminFlag != null && adminFlag.equals("true"))
            chain.doFilter(req, resp);
        else
            req.getRequestDispatcher("/error.html").forward(req, resp);
    }
}
