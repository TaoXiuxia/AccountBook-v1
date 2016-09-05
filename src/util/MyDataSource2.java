package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource2 {

    private static String url = "jdbc:mysql://localhost:3306/account";
    private static String user = "root";
    private static String password = "123456";

    private static int initCount = 5;
    private static int maxCount = 10;
    private int currentCount = 0;

    public static void main(String[] args) {
    }

    LinkedList<Connection> connectionPool = new LinkedList<Connection>();

    public MyDataSource2() {

        try {
            for (int i = 0; i < initCount; i++) {
                this.connectionPool.addLast(this.createConnection());
                this.currentCount++;
            }
        } catch (SQLException e) {
            throw new ExceptionInInitializerError();
        }
    }

    public Connection getConnection() throws SQLException {
        synchronized (connectionPool) {
            if (this.connectionPool.size() > 0)
                return this.connectionPool.removeFirst();
            if (this.currentCount < maxCount) {
                this.currentCount++;
                return this.createConnection();
            }
            throw new SQLException("已经没有可用连接");
        }
    }

    public void free(Connection conn) {
        this.connectionPool.addLast(conn);
    }

    private Connection createConnection() throws SQLException {
        Connection realConn = DriverManager.getConnection(url, user, password);
        MyConnection myConnection = new MyConnection(realConn, this);
        return myConnection;
    }
}