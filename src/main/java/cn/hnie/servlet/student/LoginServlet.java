package cn.hnie.servlet.student;

import cn.hnie.domain.Result;
import cn.hnie.service.StudentService;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 学生登录
 */
@WebServlet(name = "LoginServlet", value = "/StudentServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentID = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println(studentID+"\n"+password);
        Result result;
        if (StudentService.login(studentID, password)) {
            session.setAttribute("StudentFlag","true");
            session.setAttribute("studentId",studentID);
            result = new Result("200");
        }else {
            result = new Result("2001");
        }
        response.getWriter().write(JSONObject.toJSONString(result));
    }
}
