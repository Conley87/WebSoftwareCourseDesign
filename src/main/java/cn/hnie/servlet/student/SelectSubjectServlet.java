package cn.hnie.servlet.student;

import cn.hnie.domain.Result;
import cn.hnie.service.StudentService;
import com.alibaba.fastjson2.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "SelectSubjectServlet", value = "/student/SelectSubjectServlet")
public class SelectSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = (String)request.getSession().getAttribute("studentId");
//        String studentId = request.getParameter("studentId");
        String subjectId = request.getParameter("subjectId");
        Result result;
        //判断传入的题目id是否为可转换为数字的字符串
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(subjectId).matches()) {
            int id=Integer.parseInt(subjectId);
            boolean b = StudentService.selectSubject(studentId, id);
            if (b) {
                result = new Result("200","选题成功");
            }else
                result = new Result("2001","选题失败");
        } else {
            result = new Result("2001","请输入正确的题目id");
        }
        response.getWriter().write(JSONArray.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
