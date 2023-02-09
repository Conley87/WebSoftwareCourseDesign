package cn.hnie.service;

import cn.hnie.dao.StudentDao;
import cn.hnie.domain.Subject;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService {
    //学生登录
    public static boolean login(String StudentId, String password) {
        SqlSession session = DBUtils.getSession(true);
        StudentDao mapper = session.getMapper(StudentDao.class);
        String passwd = mapper.login(StudentId);
        session.close();
        return passwd != null && passwd.equals(password);
    }

    //查看所有发布的题目
    public static List<Subject> queryAllSubject() {
        SqlSession session = DBUtils.getSession(true);
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Subject> subjects = mapper.queryAllSubject();
        session.close();
        return subjects;
    }

    //选择题目
    public static boolean selectSubject(String stuId, int subId) {
        SqlSession session = DBUtils.getSession(true);
        StudentDao mapper = session.getMapper(StudentDao.class);
        boolean b = mapper.selectSubject(stuId, subId) == 1;
        session.close();
        return b;
    }

    public static boolean updatePasswd(String id,String passwd)  {
        SqlSession session = DBUtils.getSession(true);
        StudentDao mapper = session.getMapper(StudentDao.class);
        boolean b= mapper.updatePasswd(id,passwd)==1;
        session.close();
        return b;
    }

}
