package cn.hnie.database;

import org.junit.Test;

import java.sql.SQLException;

public class InitTest {
    @Test
    public void createDatabaseTest() {
        try {
            Init.createDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkDatabaseTest() {
        try {
            Init.checkDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createTableTest() {
        try {
            Init.createTable("manager");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkTableTest() {
        try {
            boolean b = Init.checkTable("test");
            System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thrErrorTest() {
        for (int i = 0; i < 5; i++) {
            try {
                throw new Exception("112323");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
