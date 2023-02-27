package cn.hnie.service;

import cn.hnie.dao.TeacherDao;
import cn.hnie.domain.StudentSubject;
import cn.hnie.domain.Subject;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherService {

    //教师登录
    public static boolean login(String TeacherId, String password) {
        SqlSession session = DBUtils.getSession(true);
        cn.hnie.dao.TeacherDao mapper = session.getMapper(cn.hnie.dao.TeacherDao.class);
        String passwd = mapper.login(TeacherId);
        session.close();
        return passwd != null && passwd.equals(password);
    }

    //发布题目
    public static boolean insertSubject(Subject s) {
        SqlSession session = DBUtils.getSession(true);
        cn.hnie.dao.TeacherDao mapper = session.getMapper(cn.hnie.dao.TeacherDao.class);
        boolean b = mapper.insertSubject(s);
        session.close();
        return b;
    }

    //查询所有选择该教师题目的学生
    public static List<StudentSubject> queryStudent(String teacherId) {
        SqlSession session = DBUtils.getSession(true);
        cn.hnie.dao.TeacherDao mapper = session.getMapper(TeacherDao.class);
        List<StudentSubject> studentSubjects = mapper.queryStudent(teacherId);
        session.close();
        return studentSubjects;
    }

    //选择学生
    public static int selectStudent(String teacherId, String[] stuId) {
        SqlSession session = DBUtils.getSession(true);
        cn.hnie.dao.TeacherDao mapper = session.getMapper(TeacherDao.class);
        int count = 0;
        for (String s : stuId) {
            count = count + mapper.selectStudent(teacherId, s);
        }
        session.close();
        return count;
    }

    public static boolean updatePasswd(String id,String passwd) {
        SqlSession session = DBUtils.getSession(true);
        TeacherDao mapper = session.getMapper(TeacherDao.class);
        boolean b= mapper.updatePasswd(id,passwd)==1;
        session.close();
        return b;
    }
}
