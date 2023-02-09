package cn.hnie.servlet.teacher;

import cn.hnie.domain.Result;
import cn.hnie.service.TeacherService;
import com.alibaba.fastjson2.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 教师登录
 */
@WebServlet(name = "TeacherLoginServlet", value = "/TeacherLogin")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Result result;
        if (TeacherService.login(teacherId, password)) {
            session.setAttribute("tTeacherFlag","true");
            session.setAttribute("teacherId",teacherId);
            result = new Result("200");
        }else{
            result = new Result("2001");
        }
        response.getWriter().write(JSONArray.toJSONString(result));
    }
}
