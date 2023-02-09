package cn.hnie.service;

import cn.hnie.dao.ManagerDao;
import cn.hnie.dao.StudentDao;
import cn.hnie.dao.TeacherDao;
import cn.hnie.domain.Adjust;
import cn.hnie.domain.Student;
import cn.hnie.domain.Teacher;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ManagerService {

    // 管理员登录
    public static boolean login(String adminID, String password) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        String passwd = mapper.login(adminID);
        session.close();
        return passwd != null && passwd.equals(password);
    }

    // 插入学生
    public static boolean insertStudent(Student s) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        boolean b = mapper.insertStudent(s) == 1;
        session.close();
        return b;
    }

    // 通过id删除学生
    public static int deleteStudentById(String[] id) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        int count = 0;
        for (String s:id) {
            count += mapper.deleteStudentById(s);
        }
        session.close();
        return count;
    }

    // 通过id查找学生
    public static Student selectStudentById(String id) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        Student s = mapper.selectStudentById(id);
        session.close();
        return s;
    }

    // 查找所有学上
    public static List<Student> selectStudentAll() {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        List<Student> list = mapper.selectStudentAll();
        session.close();
        return list;
    }

    //更新学生信息
    public static boolean updateStudent(Student s) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        boolean b = mapper.updateStudent(s) == 1;
        session.close();
        return b;
    }

    // 插入教师
    public static boolean insertTeacher(Teacher teacher) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        boolean b = mapper.insertTeacher(teacher) == 1;
        session.close();
        return b;
    }

    // 通过id删除教师
    public static int deleteTeacher(String[] id) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        int count=0;
        for (String s:id) {
            count += mapper.deleteTeacherById(s);

        }
        session.close();
        return count;
    }

    // 通过id查找教师
    public static Teacher selectTeacherById(String id) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        Teacher teacher = mapper.selectTeacherById(id);
        session.close();
        return teacher;
    }

    // 查找所有教师
    public static List<Teacher> selectTeacherAll() {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        List<Teacher> list = mapper.selectTeacherAll();
        session.close();
        return list;
    }

    // 更新教师信息
    public static boolean updateTeacher(Teacher t) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        boolean b = mapper.updateTeacher(t) == 1;
        session.close();
        return b;
    }

    // 调整毕设结果
    public static List<Adjust> adjust() {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        List<Adjust> adjusts = mapper.adjust();
        session.close();
        return adjusts;
    }

    // 修改密码
    public static boolean updatePasswd(String id,String passwd) {
        SqlSession session = DBUtils.getSession(true);
        ManagerDao mapper = session.getMapper(ManagerDao.class);
        boolean b= mapper.updatePasswd(id,passwd)==1;
        session.close();
        return b;
    }

    // 修改学生密码
    public static boolean updatePasswdStudent(String id,String passwd)  {
        SqlSession session = DBUtils.getSession(true);
        StudentDao mapper = session.getMapper(StudentDao.class);
        boolean b= mapper.updatePasswd(id,passwd)==1;
        session.close();
        return b;
    }

    //修改教师密码
    public static boolean updatePasswdTeacher(String id,String passwd) {
        SqlSession session = DBUtils.getSession(true);
        TeacherDao mapper = session.getMapper(TeacherDao.class);
        boolean b= mapper.updatePasswd(id,passwd)==1;
        session.close();
        return b;
    }
}
