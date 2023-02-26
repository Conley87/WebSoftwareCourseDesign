package cn.hnie.servlet.teacher;

import cn.hnie.domain.Result;
import cn.hnie.domain.StudentSubject;
import cn.hnie.service.TeacherService;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 教师查看所有选择了他发布题目的学生
 */
@WebServlet(name = "QueryStudentServlet", value = "/teacher/QueryStudentServlet")
public class QueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String teacherId = (String) session.getAttribute("teacherId");

        response.setContentType("application/json;charset=utf-8");

        Result result;
        List<StudentSubject> list = TeacherService.queryStudent(teacherId);

        if (list != null) {
            result = new Result("200", list.toArray(), "查询成功");
        } else
            result = new Result("2001", "无数据");

        response.getWriter().write(JSONObject.toJSONString(result, JSONWriter.Feature.WriteMapNullValue));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
