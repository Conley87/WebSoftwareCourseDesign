package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import cn.hnie.domain.Student;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//返回json文本，包含查到的所有学生信息
//没有和教师信息进行连接查询
@WebServlet(name = "QueryAllStudentServlet", value = "/manager/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> list = ManagerService.selectStudentAll();
        Result result;

        if (list!=null) {
            result = new Result("200", list.toArray(),"查询成功");
        }else
            result = new Result("2001","查询失败");

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
