package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.domain.Student;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//admin进行查询
@WebServlet(name = "QueryServlet", value = "/manager/QueryStudentById")
public class QueryStudentByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("id");
        List<Student> student;
        Result result;

        if (studentId.equals("")) {
            student = ManagerService.selectStudentAll();
        } else {
            student = ManagerService.selectStudentById(studentId);
        }

        if (student != null) {
            result = new Result("200", student.toArray(), "学生查询成功");
        } else
            result = new Result("2001", "学生查询失败");

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(result, JSONWriter.Feature.WriteMapNullValue));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
