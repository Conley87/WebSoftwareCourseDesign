package cn.hnie.database;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;

public class Init {
    private static DataSource dataSource;
    private static final String[] tablesName = {"admin", "teacher", "student", "subject", "stu_subj", "teacher_stu"};

    static {
        //connect to Mysql
        dataSource = DBUtils.connect("/check.properties");

        //check whether database exists
        try {
            if (!checkDatabase()) {
                createDatabase();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //connect to CourseDesign database
        dataSource = DBUtils.connect("/druid.properties");

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
        DBUtils.close(connection, statement, resultSet);
        return flag;
    }

    public static void createDatabase() throws SQLException {
        final String createSQL = "CREATE DATABASE CourseDesign";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate(createSQL);

        DBUtils.close(connection, statement);
    }

    public static boolean checkTable(String tableName) throws SQLException {
        final String checkSQL = "SHOW TABLES LIKE ?";

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(checkSQL);

        preparedStatement.setString(1, tableName);

        ResultSet resultSet = preparedStatement.executeQuery();

        boolean flag = resultSet.next();
        DBUtils.close(connection, preparedStatement, resultSet);
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
