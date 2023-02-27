package cn.hnie.servlet.teacher;

import cn.hnie.domain.Result;
import cn.hnie.service.TeacherService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//接受一个带有要选择学生id的数组
@WebServlet(name = "SelectStudentServlet", value = "/teacher/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String teacherId =(String) session.getAttribute("teacherId");

        Result result;

        String[] stu= request.getParameterValues("id");
        int i = TeacherService.selectStudent(teacherId, stu);
        if (i!=0) {
            result = new Result("200","成功添加"+i+"名学生");
        }else
            result = new Result("2001","添加失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
