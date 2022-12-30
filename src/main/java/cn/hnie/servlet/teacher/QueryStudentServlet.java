package cn.hnie.servlet.teacher;

import cn.hnie.dao.TeacherDao;
import cn.hnie.pojo.StudentSubject;
import com.alibaba.fastjson2.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 教师查看所有选择了他发布题目的学生
 */
@WebServlet(name = "QueryStudentServlet", value = "/QueryStudentServlet")
public class QueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//        String teacherId =(String) session.getAttribute("teacherId");
        String teacherId = request.getParameter("teacherId");
        List<StudentSubject> list = TeacherDao.queryStudent(teacherId);
        String s = JSONArray.toJSONString(list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
