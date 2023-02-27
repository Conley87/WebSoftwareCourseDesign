package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.domain.Student;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStudentServlet", value = "/manager/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = request.getReader().readLine();
        Student student = JSONObject.parseObject(s, Student.class);
        System.out.println(student);
        Result result;
        response.setContentType("application/json;charset=utf-8");

        if (student == null) {
            result = new Result("2001", "要添加的学生信息不正确");
            response.getWriter().write(JSONObject.toJSONString(result));
            return;
        }
        if (ManagerService.updateStudent(student)) {
            result = new Result("200", "学生信息更新成功");
        } else
            result = new Result("2001", "学生信息更新失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
