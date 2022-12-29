package cn.hnie.servlet.manager;

import cn.hnie.dao.ManagerDao;
import cn.hnie.pojo.Student;
import cn.hnie.pojo.Teacher;
import com.alibaba.fastjson2.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QueryTeacherByIdServlet", value = "/QueryTeacherByIdServlet")
public class QueryTeacherByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        Teacher teacher = ManagerDao.selectTeacherById(teacherId);
        String s = JSON.toJSONString(teacher);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
