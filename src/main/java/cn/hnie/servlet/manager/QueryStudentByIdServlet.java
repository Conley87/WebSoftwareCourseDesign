package cn.hnie.servlet.manager;

import cn.hnie.dao.ManagerDao;
import cn.hnie.pojo.Student;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//admin进行查询
@WebServlet(name = "QueryServlet", value = "/QueryServlet")
public class QueryStudentByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        Student student = ManagerDao.selectStudentById(studentId);
        String s = JSON.toJSONString(student);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
