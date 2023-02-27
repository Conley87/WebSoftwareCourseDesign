package cn.hnie.servlet.student;

import cn.hnie.domain.Result;
import cn.hnie.domain.Student;
import cn.hnie.service.StudentService;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuerySelfInfo1", value = "/student/QueryInfoServlet")
public class QuerySelfInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = (String) req.getSession().getAttribute("studentId");
        Student student = StudentService.queryInfo(studentId);
        Result result;

        resp.setContentType("application/json;charset=utf-8");

        if (student != null) {
            result = new Result("200", List.of(student).toArray(), "学生查询成功");
        } else
            result = new Result("2001", "学生查询失败");

        resp.getWriter().write(JSONObject.toJSONString(result, JSONWriter.Feature.WriteMapNullValue));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
