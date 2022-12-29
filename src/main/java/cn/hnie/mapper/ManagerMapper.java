package cn.hnie.mapper;

import cn.hnie.pojo.Student;
import cn.hnie.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerMapper {
    /**
     * 验证管理员登录
     * 查询教师和学生的所有信息
     * 修改教师和学生的密码
     */
    String login(String adminID);

    int insertStudent(Student s);
    int deleteStudentById(String s);
    Student selectStudentById(String id);
    List<Student> selectStudentAll();
    int updateStudent(Student s);

    int insertTeacher(Teacher t);
    int deleteTeacherById(String id);
    Teacher selectTeacherById(String id);
    List<Teacher> selectTeacherAll();
    int updateTeacher(Teacher t);
}
