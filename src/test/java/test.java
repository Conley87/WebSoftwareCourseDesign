import cn.hnie.dao.ManagerDao;
import cn.hnie.dao.StudentDao;
import cn.hnie.dao.TeacherDao;
import cn.hnie.pojo.Student;
import cn.hnie.pojo.Teacher;
import org.junit.Test;


public class test {
    @Test
    public void testLogin() {
        boolean login = ManagerDao.login("0102", "123452");
        System.out.println(login);
    }
    @Test
    public void testInsert() {
        Student s=new Student();
        s.setStudentId("0101");
        s.setPassword("123456");
        s.setName("张三");
        boolean b = ManagerDao.insertStudent(s);
        System.out.println(b);
    }
    @Test
    public void testInsertTeacher() {
        Teacher s=new Teacher();
        s.setTeacherId("0101");
        s.setPassword("123456");
        s.setName("张老师");
        boolean b = ManagerDao.insertTeacher(s);
        System.out.println(b);
    }
    @Test
    public void testLoginStudent() {
        boolean login = StudentDao.login("011", "123456");
        System.out.println(login);
    }
    @Test
    public void testLoginTeacher() {
        boolean login = TeacherDao.login("0101", "123456");
        System.out.println(login);
    }
}
