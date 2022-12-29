package cn.hnie.servlet.manager;

import cn.hnie.dao.ManagerDao;
import cn.hnie.pojo.Student;
import com.alibaba.fastjson2.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllStudentServlet", value = "/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> list = ManagerDao.selectStudentAll();
        String s = JSON.toJSONString(list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}