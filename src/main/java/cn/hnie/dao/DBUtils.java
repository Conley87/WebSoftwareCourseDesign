package cn.hnie.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtils {
    private static  SqlSessionFactory FACTORY;

    static {
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream("mybatis-config.xml");
            FACTORY= new SqlSessionFactoryBuilder().build(resource);
        } catch (IOException e) {
            System.out.println("资源不存在");
        }
    }
    public static SqlSession getSession(boolean autoCommit){
        return FACTORY.openSession(autoCommit);
    }
}
