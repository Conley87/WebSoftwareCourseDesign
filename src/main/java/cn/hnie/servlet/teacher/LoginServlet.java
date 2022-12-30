package cn.hnie.servlet.teacher;

import cn.hnie.dao.TeacherDao;

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
@WebServlet(name = "TeacherLoginServlet", value = "/TeacherLoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if (TeacherDao.login(teacherId, password)) {
            session.setAttribute("teacher","true");
            session.setAttribute("teacherId",teacherId);
            request.getRequestDispatcher("/teacher/teacherIndex.html").forward(request,response);
        }else{
            session.setAttribute("teacher","false");
            response.sendRedirect("/teacher.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
