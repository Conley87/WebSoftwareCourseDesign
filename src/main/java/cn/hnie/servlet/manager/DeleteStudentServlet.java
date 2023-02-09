package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet", value = "/manager/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] id = request.getParameterValues("id");
        Result result;
        response.setContentType("application/json;charset=utf-8");

        if (id==null) {
            result = new Result("2001","请选择学生");
            response.getWriter().write(JSONObject.toJSONString(result));
            return;
        }

        int i = ManagerService.deleteStudentById(id);
        if (i!=0) {
            result = new Result("200","成功删除"+i+"名学生");
        }else
            result = new Result("2001","学生删除失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
