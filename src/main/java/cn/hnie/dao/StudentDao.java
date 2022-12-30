package cn.hnie.dao;

import cn.hnie.mapper.StudentMapper;
import cn.hnie.pojo.Subject;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDao {
    //学生登录
    public static boolean login(String StudentId, String password) {
        SqlSession session = DBUtils.getSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        String passwd = mapper.login(StudentId);
        session.close();
        return passwd != null && passwd.equals(password);
    }

    //查看所有发布的题目
    public static List<Subject> queryAllSubject() {
        SqlSession session = DBUtils.getSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Subject> subjects = mapper.queryAllSubject();
        session.close();
        return subjects;
    }

    //选择题目
    public static boolean selectSubject(String stuId, int subId) {
        SqlSession session = DBUtils.getSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        boolean b = mapper.selectSubject(stuId, subId) == 1;
        session.close();
        return b;
    }

    //提交题目，将提交的文件保存到/WEB-INF/upload/studentId/ 下
    public static boolean submitSubject(String content, String stuId) {
        SqlSession session = DBUtils.getSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        boolean b = mapper.submitSubject(content, stuId) == 1;
        session.close();
        return b;
    }
}
