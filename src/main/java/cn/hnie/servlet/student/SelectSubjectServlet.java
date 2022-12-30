package cn.hnie.servlet.student;

import cn.hnie.dao.StudentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "SelectSubjectServlet", value = "/SelectSubjectServlet")
public class SelectSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String studentId = (String)request.getSession().getAttribute("studentId");
        String studentId = request.getParameter("studentId");
        String subjectId = request.getParameter("subjectId");
        //判断传入的题目id是否为可转换为数字的字符串
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(subjectId).matches()) {
            int id=Integer.parseInt(subjectId);
            boolean b = StudentDao.selectSubject(studentId, id);
            //TODO(选择题目失败)
        } else {
            //TODO(获取的subjectId不能转换为数字)
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
