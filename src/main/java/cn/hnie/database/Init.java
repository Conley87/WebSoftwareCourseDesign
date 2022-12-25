package cn.hnie.database;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;

public class Init {
    private static DataSource dataSource;
    private static final String[] tablesName = {"manager", "teacher", "student", "subject", "stu_subj"};

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
        for (String table : tablesName) {
            try {
                if (!checkTable(table)) {
                    createTable(table);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    //todo finish tables structure
    public static void createTable(String tableName) throws SQLException {
        final String managerSQL = "CREATE TABLE `manager` (\n" +
                "\t`adminID` VARCHAR ( 20 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`password` VARCHAR ( 255 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`phone_number` CHAR ( 11 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,\n" +
                "\tPRIMARY KEY ( `adminID` ) USING BTREE \n" +
                ") ENGINE = INNODB CHARACTER \n" +
                "SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;";
        final String teacherSQL = "CREATE TABLE `teacher` (\n" +
                "\t`teacherID` VARCHAR ( 20 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`name` VARCHAR ( 20 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`age` INT NULL DEFAULT NULL,\n" +
                "\t`department` VARCHAR ( 25 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,\n" +
                "\t`phone_number` VARCHAR ( 11 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,\n" +
                "\tPRIMARY KEY ( `teacherID` ) USING BTREE \n" +
                ") ENGINE = INNODB CHARACTER \n" +
                "SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;";
        final String stuSQL = "CREATE TABLE `student` (\n" +
                "\t`studentID` VARCHAR ( 20 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`name` VARCHAR ( 20 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`age` INT NULL DEFAULT NULL,\n" +
                "\t`sex` CHAR ( 2 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,\n" +
                "\t`department` VARCHAR ( 25 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,\n" +
                "\t`phone_number` CHAR ( 11 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,\n" +
                "\tPRIMARY KEY ( `studentID` ) USING BTREE \n" +
                ") ENGINE = INNODB CHARACTER \n" +
                "SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;";
        final String subjectSQL = "CREATE TABLE `subject` (\n" +
                "\t`subjectID` VARCHAR ( 255 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`teacherID` VARCHAR ( 20 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\tPRIMARY KEY ( `subjectID` ) USING BTREE,\n" +
                "\tINDEX `t` ( `teacherID` ASC ) USING BTREE,\n" +
                "\tCONSTRAINT `t` FOREIGN KEY ( `teacherID` ) REFERENCES `teacher` ( `teacherID` ) ON DELETE CASCADE ON UPDATE CASCADE \n" +
                ") ENGINE = INNODB CHARACTER \n" +
                "SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;";
        final String stu_subjSQL = "CREATE TABLE `stu_subj` (\n" +
                "\t`studentID` VARCHAR ( 20 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,\n" +
                "\t`subjectID` VARCHAR ( 255 ) CHARACTER \n" +
                "\tSET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,\n" +
                "\tPRIMARY KEY ( `studentID` ) USING BTREE,\n" +
                "\tINDEX `subj` ( `subjectID` ASC ) USING BTREE,\n" +
                "\tCONSTRAINT `stu` FOREIGN KEY ( `studentID` ) REFERENCES `student` ( `studentID` ) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "\tCONSTRAINT `subj` FOREIGN KEY ( `subjectID` ) REFERENCES `subject` ( `subjectID` ) ON DELETE CASCADE ON UPDATE CASCADE \n" +
                ") ENGINE = INNODB CHARACTER \n" +
                "SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;";

        HashMap<String, String> map = new HashMap<>();
        map.put("manager", managerSQL);
        map.put("teacher", teacherSQL);
        map.put("student", stuSQL);
        map.put("subject", subjectSQL);
        map.put("stu_subj", stu_subjSQL);

        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        System.out.println(map.get(tableName));
        statement.executeUpdate(map.get(tableName));

        DBUtils.close(connection, statement);
    }
}
