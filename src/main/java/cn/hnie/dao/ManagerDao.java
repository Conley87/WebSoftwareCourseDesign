package cn.hnie.dao;

import cn.hnie.mapper.ManagerMapper;
import cn.hnie.pojo.Student;
import cn.hnie.pojo.Teacher;
import org.apache.ibatis.session.SqlSession;

public class ManagerDao {

    //登录
    public static boolean login(String adminID, String password) {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        String passwd = mapper.login(adminID);
        session.close();
        return passwd != null && passwd.equals(password);
    }

    //插入学生
    public static boolean insertStudent(Student s) {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        boolean b = mapper.insertStudent(s);
        session.close();
        return b;
    }

    //插入教师
    public static boolean insertTeacher(Teacher teacher) {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        boolean b = mapper.insertTeacher(teacher);
        session.close();
        return b;
    }
}
