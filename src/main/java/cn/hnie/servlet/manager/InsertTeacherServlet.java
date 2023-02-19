package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import cn.hnie.domain.Teacher;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "InsertTeacherServlet", value = "/manager/InsertTeacherServlet")
public class InsertTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Result result;
        response.setContentType("application/json;charset=utf-8");
        Teacher teacher = JSONObject.parseObject(s, Teacher.class);

        if (teacher==null) {
            result = new Result("2001","请输入正确的教师信息");
            response.getWriter().write(JSONObject.toJSONString(result));
            return;
        }

        teacher.setPassword("12345");

        boolean b = ManagerService.insertTeacher(teacher);
        if (b) {
            result = new Result("200","教师添加成功");
        }else
            result = new Result("2001","教师添加失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
