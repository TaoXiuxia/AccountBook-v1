package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.MyDataSource2;

public final class JdbcUtils2 {

    private static MyDataSource2 myDataSource = null;

    private JdbcUtils2() {
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            myDataSource = new MyDataSource2();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        // return DriverManager.getConnection(url, user, password);
        return myDataSource.getConnection(); // 取连接
    }

    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close(); //现在close方法就是将连接放回连接池，而不是关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null)
                         conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}