package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONObject;

import javax.management.relation.RelationTypeSupport;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改密码
 */
@WebServlet( value = "/manager/UpdatePasswdServlet")
public class UpdatePasswdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pwd = request.getParameter("pwd");
        String id =(String) request.getSession().getAttribute("adminID");
        Result result;
        response.setContentType("application/json;charset=utf-8");

        if (ManagerService.updatePasswd(id,pwd)) {
            result=new Result("200","密码修改成功");
        }else
            result = new Result("2001","密码修改失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
