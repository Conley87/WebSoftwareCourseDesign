package cn.hnie.mapper;

import cn.hnie.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    //登录
    String login(String studentId);
    //查看题目
    List<Subject> queryAllSubject();
    //选择题目
    int selectSubject(@Param("stuId") String stuId, @Param("subId") int subId);

    int submitSubject(@Param("content") String content,@Param("stuId") String stuId);
}
