package cn.hnie.servlet.manager;

import cn.hnie.service.ManagerService;
import cn.hnie.domain.Adjust;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//将结果导出成excel表格，下载
@WebServlet(name = "DownloadServlet", value = "/manager/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获得调整后的毕设结果
        List<Adjust> adjust = ManagerService.adjust();
        String[] title = {"学号", "姓名", "题目编号", "题目", "教师"};
        int length = title.length;

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;

        //创建表头
        for (int i = 0; i < length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }

        //添加数据,从第二行开始
        for (int i = 1; i < (adjust.size() + 1); i++) {
            HSSFRow nextRow = sheet.createRow(i);//第i行
            Adjust adjust1 = adjust.get(i - 1);
            for (int j = 0; j < length; j++) {
                HSSFCell cell1 = nextRow.createCell(j);
                if (j == 0)
                    cell1.setCellValue(adjust1.getStuId());
                if (j == 1)
                    cell1.setCellValue(adjust1.getName());
                if (j == 2)
                    cell1.setCellValue(adjust1.getSubId());
                if (j == 3)
                    cell1.setCellValue(adjust1.getTitle());
                if (j == 4)
                    cell1.setCellValue(adjust1.getTeaName());
            }
        }

        // 输出文件
        response.addHeader("content-disposition", "attachment;filename=tmp.xls");
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }catch (RuntimeException | IOException e) {
            ;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
