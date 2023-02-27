package cn.hnie.servlet.student;

import cn.hnie.domain.Result;
import cn.hnie.service.StudentService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/student/UpdatePasswdServlet")
public class UpdatePasswdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("studentId");
        String pwd = request.getParameter("pwd");
        Result result;

        response.setContentType("application/json;charset=utf-8");
        if (StudentService.updatePasswd(id,pwd)) {
            result = new Result("200","密码更新成功");
        }else
            result = new Result("2001","密码更新失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
