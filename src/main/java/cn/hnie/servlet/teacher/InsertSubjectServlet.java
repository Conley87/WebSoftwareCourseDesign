package cn.hnie.servlet.teacher;

import cn.hnie.dao.TeacherDao;
import cn.hnie.pojo.Subject;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertSubjectServlet", value = "/InsertSubjectServlet")
public class InsertSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherId =(String) request.getSession().getAttribute("teacherId");
        if (teacherId==null) {
            //TODO(不正常访问)
        }else {
            String s = request.getReader().readLine();
            Subject subject = JSONObject.parseObject(s, Subject.class);
            subject.setTeacherId(teacherId);
            TeacherDao.insertSubject(subject);
            //TODO(插入成功返回界面)
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
