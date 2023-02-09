package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import cn.hnie.domain.Student;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "InsertStudentServlet", value = "/manager/InsertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Result result;
        response.setContentType("application/json;charset=utf-8");
        Student student = JSONObject.parseObject(s, Student.class);
        if (student==null) {
            result = new Result("2001","请输入正确的学生信息");
            response.getWriter().write(JSONObject.toJSONString(result));
            return;
        }

        boolean b = ManagerService.insertStudent(student);
        if (b) {
            result = new Result("200","学生添加成功");
        }else
            result = new Result("2001","学生添加失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
