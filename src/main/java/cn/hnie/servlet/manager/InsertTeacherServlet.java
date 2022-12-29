package cn.hnie.servlet.manager;

import cn.hnie.dao.ManagerDao;
import cn.hnie.pojo.Student;
import cn.hnie.pojo.Teacher;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "InsertTeacherServlet", value = "/InsertTeacherServlet")
public class InsertTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Teacher teacher = JSONObject.parseObject(s, Teacher.class);
        boolean b = ManagerDao.insertTeacher(teacher);
        //TODO(返回成功信息,和跳转页面)
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
