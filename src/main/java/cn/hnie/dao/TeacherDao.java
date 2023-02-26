package cn.hnie.dao;

import cn.hnie.domain.StudentSubject;
import cn.hnie.domain.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherDao {
    String login(String id);
    //发布题目
    boolean insertSubject(Subject s);

    List<StudentSubject> queryStudent(String teacherId);
    //选择学生
    int selectStudent(@Param("id") String id, @Param("stuId") String stuId);

    //修改密码
    int updatePasswd(@Param("id") String id,@Param("passwd") String passwd);
}
