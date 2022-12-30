package cn.hnie.servlet.student;

import cn.hnie.dao.StudentDao;
import cn.hnie.pojo.Subject;
import com.alibaba.fastjson2.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//返回查询到的所有题目
//没有和教师表进行连接查询
@WebServlet(name = "QuerySubjectServlet", value = "/QuerySubjectServlet")
public class QuerySubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subjects = StudentDao.queryAllSubject();
        for (Subject s:subjects)
            System.out.println(s);
        String s = JSONArray.toJSONString(subjects);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
