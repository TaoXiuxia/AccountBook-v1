package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Income;
import model.Item;
import util.JdbcUtils2;

public class IncomeDaoImpl implements IncomeDao {

	@Override
	public void addIncome(Income income) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "insert into income values (null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, income.getUserId());
			ps.setInt(2, income.getItemId());
			ps.setFloat(3, income.getMoney());
			ps.setDate(4, new java.sql.Date(income.getDate().getTime()));
			ps.setString(5, income.getRemark());
			int isSuccess = ps.executeUpdate();
			if (1 == isSuccess) {
				System.out.println("插入Income成功");
			} else {
				System.out.println("插入Income失败");
			}
			JdbcUtils2.free(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addIncomeItem(Item IncomeItem) {
		// TODO Auto-generated method stub

	}

}
