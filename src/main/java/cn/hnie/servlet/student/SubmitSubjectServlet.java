package cn.hnie.servlet.student;

import cn.hnie.dao.StudentDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "SubmitSubjectServlet", value = "/SubmitSubjectServlet")
public class SubmitSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//        String studentId = (String) session.getAttribute("studentId");
        String studentId =request.getParameter("studentId");
        //文件保存目录
        String stuPath = "/WEB-INF/upload/" + studentId;
        StringBuilder savePath = new StringBuilder(this.getServletContext().getRealPath(stuPath));
        File file = new File(savePath.toString());
        if (!file.exists() && !file.isDirectory())
            file.mkdirs();
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(file);
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding("utf-8");
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            Iterator<FileItem> iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    //TODO(上传文件的普通字段)
                } else {
                    String fileName = item.getName();
                    //文件名字
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
                    //文件存放相对路径，相对整个web应用来说
                    stuPath=stuPath+"/"+fileName;
                    InputStream stream = item.getInputStream();
                    //文件写入绝对路径
                    String saveFile = savePath.append(File.separator).append(fileName).toString();
                    FileOutputStream fos = new FileOutputStream(saveFile);
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    while ((length = stream.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                    stream.close();
                    fos.close();
                    item.delete();
                    StudentDao.submitSubject(stuPath, studentId);
                }
            }

        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
