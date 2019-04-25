package top.cj466.JavaUtils.JDBC;


import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {

    private static String DRIVER_CLASS;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    // 加载配置文件
    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        DRIVER_CLASS = resourceBundle.getString("DRIVER_CLASS");
        URL = resourceBundle.getString("URL");
        USER = resourceBundle.getString("USER");
        PASSWORD = resourceBundle.getString("PASSWORD");
    }

    // 注册驱动
    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }

    public static void close(Connection conn, Statement stmt, ResultSet res) {
        closeResultSet(res);
        closeStatement(stmt);
        closeConnection(conn);
    }

    private static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    private static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    private static void closeResultSet(ResultSet res) {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
            }
        }
    }

}
