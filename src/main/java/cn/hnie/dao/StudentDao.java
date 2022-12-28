package cn.hnie.dao;

import cn.hnie.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

public class StudentDao {
    //登录
    public static boolean login(String StudentId, String password) {
        SqlSession session = DBUtils.getSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        String passwd = mapper.login(StudentId);
        session.close();
        return passwd != null && passwd.equals(password);
    }
}
