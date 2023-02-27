package cn.hnie.servlet.manager;

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

@WebServlet(name = "QueryTeacherByIdServlet", value = "/manager/QueryTeacherByIdServlet")
public class QueryTeacherByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherId = request.getParameter("id");
        List<Teacher> teacher;
        Result result;

        if (teacherId.equals("")) {
            teacher = ManagerService.selectTeacherAll();
        } else {
            teacher = ManagerService.selectTeacherById(teacherId);
        }

        if (teacher != null) {
            result = new Result("200", teacher.toArray(), "教师查询成功");
        } else
            result = new Result("2001", "教师查询失败");

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(result, JSONWriter.Feature.WriteMapNullValue));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
