package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import cn.hnie.domain.Teacher;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//返回一个json文本，包含查到的所有文本教师信息
@WebServlet(name = "QueryAllTeacherServlet", value = "/manager/QueryAllTeacherServlet")
public class QueryAllTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teacher> list = ManagerService.selectTeacherAll();
        Result result;
        response.setContentType("application/json;charset=utf-8");

        if (list!=null) {
            result = new Result("200",list.toArray(),"教师查询成功");
        }else
            result = new Result("2001","教师查询失败");
        String s =JSON.toJSONString(list);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
