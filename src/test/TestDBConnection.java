package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtils;

public class TestDBConnection {
	public static void main(String[] args) throws SQLException {
		Connection conn = JdbcUtils.getConnection();

		String sql = "insert  into user values (null,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "zhangsan");
		ps.executeUpdate();
		JdbcUtils.free(null, ps, conn);
	}
}
