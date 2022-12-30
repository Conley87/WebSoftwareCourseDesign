package cn.hnie.servlet.teacher;

import cn.hnie.dao.TeacherDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//接受一个带有要选择学生id的数组
@WebServlet(name = "SelectStudentServlet", value = "/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//        String teacherId =(String) session.getAttribute("teacherId");
        String teacherId = request.getParameter("teacherId");
        String[] stu= request.getParameterValues("stu");
        TeacherDao.selectStudent(teacherId,stu);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
