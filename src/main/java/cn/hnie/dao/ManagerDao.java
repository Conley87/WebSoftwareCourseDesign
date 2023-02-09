package cn.hnie.dao;

import cn.hnie.domain.Adjust;
import cn.hnie.domain.Student;
import cn.hnie.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 验证管理员登录<br/>
 * 查询教师和学生的所有信息<br/>
 * 修改教师和学生的密码<br/>
 */
@Mapper
public interface ManagerDao {
    /**
     * 根据管理员id返回密码
     * @param adminID 管理员id
     * @return 密码
     */
    String login(String adminID);

    /**
     * 插入学生
     */
    int insertStudent(Student s);
    /**
     * 通过id删除学生
     */
    int deleteStudentById(String id);
    /**
     * 通过id查询学生
     */
    Student selectStudentById(String id);
    /**
     * 查询所有学生
     */
    List<Student> selectStudentAll();

    int updateStudent(Student s);

    /**
     * 插入教师信息
     */
    int insertTeacher(Teacher t);
    /**
     * 通过id删除教师
     */
    int deleteTeacherById(String id);
    /**
     * 通过id查询教师
     */
    Teacher selectTeacherById(String id);
    /**
     * 查询所有教师信息
     */
    List<Teacher> selectTeacherAll();
    /**
     * 更新教师信息
     */
    int updateTeacher(Teacher t);

    //调整毕设结果
    List<Adjust> adjust();

    int updatePasswd(@Param("id") String id,@Param("passwd") String passwd);
}
