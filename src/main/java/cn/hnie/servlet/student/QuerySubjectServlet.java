package cn.hnie.servlet.student;

import cn.hnie.domain.Result;
import cn.hnie.domain.Subject;
import cn.hnie.service.StudentService;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//返回查询到的所有题目包括题目所属教师
@WebServlet(name = "QuerySubjectServlet", value = "/student/QuerySubjectServlet")
public class QuerySubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subjects = StudentService.queryAllSubject();
        Result result;

        response.setContentType("application/json;charset=utf-8");

        if (subjects != null) {
            result = new Result("200", subjects.toArray());
        } else
            result = new Result("2001", null, "数据为空");
        response.getWriter().write(JSONArray.toJSONString(result, JSONWriter.Feature.WriteMapNullValue));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
