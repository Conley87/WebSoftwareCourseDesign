package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONArray;

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
@WebServlet(name = "AdminServlet", value = "/AdminServlet")//TODO(设置登录页面的处理路径)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String adminID = req.getParameter("adminID");
        String passwd = req.getParameter("passwd");

        HttpSession session = req.getSession();
        resp.setContentType("application/json;charset=utf-8");
        Result result;

        if (ManagerService.login(adminID, passwd)) {
            session.setAttribute("adminFlag", "true");
            result = new Result("200");
        } else {
            result = new Result("2001");
        }
        resp.getWriter().write(JSONArray.toJSONString(result));
    }
}
