package cn.hnie.servlet.teacher;

import cn.hnie.domain.Result;
import cn.hnie.service.TeacherService;
import cn.hnie.domain.StudentSubject;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
        String teacherId =(String) session.getAttribute("teacherId");
//        String teacherId = request.getParameter("teacherId");

        Result result;
        List<StudentSubject> list = TeacherService.queryStudent(teacherId);
        if (list!=null) {
            result = new Result("200",list.toArray(),"查询成功");
        }else
            result = new Result("2001","无数据");
        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
