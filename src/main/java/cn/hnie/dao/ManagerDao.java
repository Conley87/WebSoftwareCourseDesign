package cn.hnie.dao;

import cn.hnie.mapper.ManagerMapper;
import cn.hnie.pojo.Student;
import cn.hnie.pojo.Teacher;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
        boolean b = mapper.insertStudent(s)==1;
        session.close();
        return b;
    }
    //通过id删除学生
    public static boolean deleteStudentById(String id){
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        boolean b=mapper.deleteStudentById(id)==1;
        session.close();
        return b;
    }
    //通过id查找学生
    public static Student selectStudentById(String id){
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        Student s=mapper.selectStudentById(id);
        session.close();
        return s;
    }
    //查找所有学上
    public static List<Student> selectStudentAll() {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        List<Student> list=mapper.selectStudentAll();
        session.close();
        return list;
    }
    //更新学生呢信息
    public static boolean updateStudent(Student s) {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        boolean b=mapper.updateStudent(s)==1;
        session.close();
        return b;
    }

    //插入教师
    public static boolean insertTeacher(Teacher teacher) {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        boolean b = mapper.insertTeacher(teacher)==1;
        session.close();
        return b;
    }
    //通过id删除教师
    public static boolean deleteTeacher(String id){
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        boolean b=mapper.deleteTeacherById(id)==1;
        session.close();
        return b;
    }
    //通过id查找教师
    public static Teacher selectTeacherById(String id) {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        Teacher teacher=mapper.selectTeacherById(id);
        session.close();
        return teacher;
    }
    //查找所有教师
    public static List<Teacher> selectTeacherAll() {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        List<Teacher> list=mapper.selectTeacherAll();
        session.close();
        return list;
    }
    //更新教师信息
    public static boolean updateTeacher(Teacher t) {
        SqlSession session = DBUtils.getSession(true);
        ManagerMapper mapper = session.getMapper(ManagerMapper.class);
        boolean b=mapper.updateTeacher(t)==1;
        session.close();
        return b;
    }
}
