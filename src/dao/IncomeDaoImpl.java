package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Income;
import model.Item;
import util.JdbcUtils2;

public class IncomeDaoImpl implements IncomeDao {

	/**
	 * 插入income
	 * @param income
	 */
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
			System.out.println(income.getMoney());
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

	/**
	 * 插入income项
	 * @param incomeItem
	 */
	@Override
	public void addIncomeItem(Item incomeItem) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "insert into item values (null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, incomeItem.getUserId());
			ps.setString(2, incomeItem.getItemName());
			ps.setString(3, incomeItem.getIsPublic());
			ps.setString(4, incomeItem.getInOrOut());
			ps.setString(5, incomeItem.getRemark());
			int isSuccess = ps.executeUpdate();
			if (1 == isSuccess) {
				System.out.println("插入IncomeItem成功");
			} else {
				System.out.println("插入IncomeItem失败");
			}
			JdbcUtils2.free(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据userId获取该用户的收入项（公共的项和自己创建的私有项）
	 * @param userId
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getIncomeItemByUserId(int userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<HashMap<String, Object>> items = new ArrayList<HashMap<String,Object>>();
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "SELECT item_id, item_name from item where in_or_out='in' and (user_id=1 or user_id =? ) ORDER BY item_id";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
            String[]colNames=new String[count];	 //列名
            for(int i=1;i<=count;i++){
                colNames[i-1]=rsmd.getColumnName(i);
            }
            while(rs.next()){
                HashMap<String, Object>data=new HashMap<String, Object>();
                for(int i=0;i<colNames.length;i++){
                    data.put(colNames[i], rs.getObject(colNames[i]));
                }
                items.add(data);
            }
			JdbcUtils2.free(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	/**
	 * 根据userId获取该用户的收入，具体的每一项细节
	 * @param userId
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getIncomeByUserId(int userId){
		Connection conn = null;
		PreparedStatement ps = null;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "SELECT item.item_name, income.money, income.date, income.remark FROM income,item WHERE income.user_id = ? AND income.item_id = item.item_id ORDER BY date DESC";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
            String[]colNames=new String[count];	 //列名
            for(int i=1;i<=count;i++){
                colNames[i-1]=rsmd.getColumnName(i);
            }
            while(rs.next()){
                HashMap<String, Object>data=new HashMap<String, Object>();
                for(int i=0;i<colNames.length;i++){
                    data.put(colNames[i], rs.getObject(colNames[i]));
                }
                list.add(data);
            }
			JdbcUtils2.free(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}




















