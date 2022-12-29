package cn.hnie.servlet.manager;

import cn.hnie.dao.ManagerDao;
import cn.hnie.pojo.Student;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateStudentServlet", value = "/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = request.getReader().readLine();
        Student student = JSONObject.parseObject(s, Student.class);
        ManagerDao.updateStudent(student);
        //TODO(返回修改成功信息，和跳转页面)
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
