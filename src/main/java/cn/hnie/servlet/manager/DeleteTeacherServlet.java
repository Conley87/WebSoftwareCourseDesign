package cn.hnie.servlet.manager;

import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTeacherServlet", value = "/manager/DeleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] id = request.getParameterValues("id");
        Result result;
        response.setContentType("application/json;charset=utf-8");

        if (id==null) {
            result = new Result("2001","请选择教师");
            response.getWriter().write(JSONObject.toJSONString(result));
            return;
        }

        int i = ManagerService.deleteTeacher(id);
        if (i!=0) {
            result = new Result("200","成功删除"+i+"名教师");
        }else
            result = new Result("2001","教师删除失败");

        response.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
