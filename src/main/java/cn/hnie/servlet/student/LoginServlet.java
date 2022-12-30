package cn.hnie.servlet.student;

import cn.hnie.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 学生登录
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentID = request.getParameter("studentID");
        String password = request.getParameter("password");

        if (StudentDao.login(studentID, password)) {
            session.setAttribute("StudentFlag","true");
            session.setAttribute("studentId",studentID);
            request.getRequestDispatcher("/student/studentIndex.html").forward(request,response);
        }else {
            session.setAttribute("StudentFlag","false");
            response.sendRedirect("/student.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
