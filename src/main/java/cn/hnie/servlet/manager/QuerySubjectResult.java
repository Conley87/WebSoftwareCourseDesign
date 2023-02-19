package cn.hnie.servlet.manager;

import cn.hnie.domain.Adjust;
import cn.hnie.domain.Result;
import cn.hnie.service.ManagerService;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuerySubjectResult", value = "/manager/QuerySubjectResultServlet")
public class QuerySubjectResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Adjust> adjust = ManagerService.adjust();
        Result result;

        resp.setContentType("application/json;charset=utf-8");

        if (adjust != null) {
            result = new Result("200", adjust.toArray());
        } else
            result = new Result("2001", "课题导出失败");

        resp.getWriter().write(JSONObject.toJSONString(result, JSONWriter.Feature.WriteMapNullValue));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
