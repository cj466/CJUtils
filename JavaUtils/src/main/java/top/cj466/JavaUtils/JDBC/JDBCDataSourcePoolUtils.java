package top.cj466.JavaUtils.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDataSourcePoolUtils { // 德鲁伊连接池工具类  用于spring家族的JDBCTemplate

    private static DataSource dataSource = null;

    static {
        try {
            // 获取配置文件IO流
            InputStream is = JDBCDataSourcePoolUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            // 读取配置
            Properties pr = new Properties();
            pr.load(is);
            // 使用工厂创建连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 提供获取连接池的方法
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 提供获取连接的方法
    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
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
