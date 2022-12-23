package cn.hnie.database;

import org.junit.Test;

import javax.sql.DataSource;

public class DBUtilsTest {
    @Test
    public void connectTest(){
        DataSource dataSource = DBUtils.connect("/check.properties");
        System.out.println(dataSource);
    }
}
