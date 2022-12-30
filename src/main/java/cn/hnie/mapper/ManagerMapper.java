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
    String login(String adminID);//通过adminID返回密码

    int insertStudent(Student s);//插入学生
    int deleteStudentById(String s);//通过id删除学生
    Student selectStudentById(String id);//通过id选择学上
    List<Student> selectStudentAll();//选择所有学生
    int updateStudent(Student s);//更新学生信息

    int insertTeacher(Teacher t);//插入教师信息
    int deleteTeacherById(String id);//通过id删除教师
    Teacher selectTeacherById(String id);//通过id选择教师
    List<Teacher> selectTeacherAll();//选择所有教师
    int updateTeacher(Teacher t);//更新教师信息
}
