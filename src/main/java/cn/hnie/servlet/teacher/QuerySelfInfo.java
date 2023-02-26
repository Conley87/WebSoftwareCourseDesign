package cn.hnie.servlet.teacher;

import cn.hnie.domain.Result;
import cn.hnie.domain.Teacher;
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

@WebServlet(name = "QuerySelfInfo2", value = "/teacher/QueryInfoServlet")
public class QuerySelfInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = (String) req.getSession().getAttribute("teacherId");
        List<Teacher> teacher = ManagerService.selectTeacherById(teacherId);
        Result result;

        resp.setContentType("application/json;charset=utf-8");

        if (teacher != null) {
            result = new Result("200", teacher.toArray(), "教师查询成功");
        } else
            result = new Result("2001", "教师查询失败");

        resp.getWriter().write(JSONObject.toJSONString(result, JSONWriter.Feature.WriteMapNullValue));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
