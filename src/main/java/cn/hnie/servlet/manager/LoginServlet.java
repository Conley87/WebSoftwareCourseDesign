package cn.hnie.servlet.manager;

import cn.hnie.dao.ManagerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员登录验证
 */
@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String adminID = req.getParameter("adminID");
        String passwd = req.getParameter("passwd");
        HttpSession session = req.getSession();

        if (ManagerDao.login(adminID, passwd)) {
            //登录成功在session中设置该用户对admin的操作权限
            session.setAttribute("adminFlag", "true");
            req.getRequestDispatcher("/admin/managerIndex.html").forward(req, resp);
        } else {
            session.setAttribute("adminFlag", "false");
            resp.sendRedirect("/error.html");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
