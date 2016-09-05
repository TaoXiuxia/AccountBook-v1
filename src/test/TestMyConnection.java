package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcUtils2;

public class TestMyConnection {

	public static void main(String[] args) throws SQLException {
		Connection conn = JdbcUtils2.getConnection();
		
		String sql = "insert into user values (null,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "zhangsan");
		int i = ps.executeUpdate();
		System.out.println(i);
		JdbcUtils2.free(null, ps, conn);
	}
}
