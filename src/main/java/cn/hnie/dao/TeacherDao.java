package cn.hnie.dao;

import cn.hnie.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;

public class TeacherDao {

    //登录
    public static boolean login(String TeacherId, String password) {
        SqlSession session = DBUtils.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        String passwd = mapper.login(TeacherId);
        session.close();
        return passwd != null && passwd.equals(password);
    }
}
