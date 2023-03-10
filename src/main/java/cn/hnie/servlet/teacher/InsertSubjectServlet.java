package cn.hnie.servlet.teacher;

import cn.hnie.domain.Result;
import cn.hnie.domain.Subject;
import cn.hnie.service.TeacherService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加题目
 */
@WebServlet(name = "InsertSubjectServlet", value = "/teacher/InsertSubjectServlet")
public class InsertSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherId = (String) request.getSession().getAttribute("teacherId");
        Result result;

        String s = request.getReader().readLine();
        Subject subject = JSONObject.parseObject(s, Subject.class);
        subject.setTeacherId(teacherId);
        if (TeacherService.insertSubject(subject)) {
            result = new Result("200","题目添加成功");
        }else
            result = new Result("2001","题目添加失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
