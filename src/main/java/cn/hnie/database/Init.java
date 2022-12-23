package cn.hnie.database;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Init {
    private static DataSource dataSource;
    private static final String[] tablesName = {"admin", "teacher", "student", "subject", "stu_subj", "teacher_stu"};

    static {
        Properties properties = new Properties();
        InputStream inputStream = Init.class.getResourceAsStream("/check.properties");
        try {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //check whether database exists
        try {
            if (!checkDatabase()) {
                createDatabase();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //connect to CourseDesign database
        properties.clear();
        inputStream = Init.class.getResourceAsStream("/druid.properties");
        try {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //check whether tables exist
        try {
            for (String table : tablesName) {
                if (!checkTable(table)) {
//                    createTable(table);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean checkDatabase() throws SQLException {
        final String checkSQL = "SHOW DATABASES LIKE 'CourseDesign'";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(checkSQL);

        boolean flag = resultSet.next();
        return flag;
    }

    public static void createDatabase() throws SQLException {
        final String createSQL = "CREATE DATABASE CourseDesign";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate(createSQL);
    }

    public static boolean checkTable(String tableName) throws SQLException {
        final String checkSQL = "SHOW TABLES LIKE ?";

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(checkSQL);

        preparedStatement.setString(1, tableName);

        ResultSet resultSet = preparedStatement.executeQuery();

        boolean flag = resultSet.next();
        return flag;
    }

    public static void createTable(String tableName) throws SQLException {
        final String adminSQL = "";
        final String teacherSQL = "";
        final String stuSQL = "";
        final String subjectSQL = "";
        final String stu_subjSQL = "";
        final String teacher_stuSQL = "";


    }
}
