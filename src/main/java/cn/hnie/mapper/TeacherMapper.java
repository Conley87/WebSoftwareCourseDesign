package cn.hnie.mapper;

import cn.hnie.pojo.StudentSubject;
import cn.hnie.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    String login(String id);
    //发布题目
    boolean insertSubject(Subject s);

    List<StudentSubject> queryStudent(String teacherId);
    //选择学生
    int selectStudent(@Param("id") String id, @Param("stuId") String stuId);
}
