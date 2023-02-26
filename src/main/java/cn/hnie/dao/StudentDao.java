package cn.hnie.dao;

import cn.hnie.domain.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao {
    //登录
    String login(String studentId);
    //查看题目
    List<Subject> queryAllSubject();
    //选择题目
    int selectSubject(@Param("stuId") String stuId, @Param("subId") int subId);

    // 修改密码
    int updatePasswd(@Param("id") String id,@Param("passwd") String passwd);
//    int submitSubject(@Param("content") String content,@Param("stuId") String stuId);
}
