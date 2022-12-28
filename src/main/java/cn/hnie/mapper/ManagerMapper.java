package cn.hnie.mapper;

import cn.hnie.pojo.Student;
import cn.hnie.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerMapper {
    /**
     * 验证管理员登录
     * 查询教师和学生的所有信息
     * 修改教师和学生的密码
     */
    String login(String adminID);
    boolean insertStudent(Student s);
    boolean insertTeacher(Teacher t);
}
