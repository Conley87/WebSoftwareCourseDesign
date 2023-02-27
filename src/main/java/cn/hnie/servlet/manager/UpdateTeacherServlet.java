package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.domain.Teacher;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateTeacherServlet", value = "/manager/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = request.getReader().readLine();
        Teacher teacher = JSONObject.parseObject(s, Teacher.class);
        Result result;
        response.setContentType("application/json;charset=utf-8");

        if (teacher==null) {
            result = new Result("200","请添加正确的教师信息");
            response.getWriter().write(JSONObject.toJSONString(result));
        }

        if(ManagerService.updateTeacher(teacher)) {
            result = new Result("200","教师信息添加成功");
        }else
            result = new Result("2001","教师信息添加失败");

        response.getWriter().write(JSONObject.toJSONString(result));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
