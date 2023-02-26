package cn.hnie.servlet.teacher;

import cn.hnie.domain.Result;
import cn.hnie.service.TeacherService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
