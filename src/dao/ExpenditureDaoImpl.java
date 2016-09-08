package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Expenditure;
import model.Income;
import model.Item;
import util.JdbcUtils2;

public class ExpenditureDaoImpl implements ExpenditureDao{
	/**
	 * 插入Expenditure
	 * @param Expenditure
	 */
	@Override
	public void addExpenditure(Expenditure expenditure) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "insert into expenditure values (null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, expenditure.getUserId());
			ps.setInt(2, expenditure.getItemId());
			ps.setFloat(3, expenditure.getMoney());
			ps.setDate(4, new java.sql.Date(expenditure.getDate().getTime()));
			ps.setString(5, expenditure.getRemark());
			int isSuccess = ps.executeUpdate();
			if (1 == isSuccess) {
				System.out.println("插入expenditure成功");
			} else {
				System.out.println("插入expenditure失败");
			}
			JdbcUtils2.free(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入expenditure项
	 * @param expenditureItem
	 */
	@Override
	public void addExpenditureItem(Item expenditureItem) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "insert into item values (null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, expenditureItem.getUserId());
			ps.setString(2, expenditureItem.getItemName());
			ps.setString(3, expenditureItem.getIsPublic());
			ps.setString(4, expenditureItem.getInOrOut());
			ps.setString(5, expenditureItem.getRemark());
			int isSuccess = ps.executeUpdate();
			if (1 == isSuccess) {
				System.out.println("插入expenditureItem成功");
			} else {
				System.out.println("插入expenditureItem失败");
			}
			JdbcUtils2.free(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据userId获取该用户的支出项（公共的项和自己创建的私有项）
	 * @param userId
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getExpenditureItemByUserId(int userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<HashMap<String, Object>> items = new ArrayList<HashMap<String,Object>>();
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "SELECT item_id, item_name from item where in_or_out='out' and (user_id=1 or user_id =? ) ORDER BY item_id";
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
	public List<HashMap<String, Object>> getExpenditureByUserId(int userId){
		Connection conn = null;
		PreparedStatement ps = null;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "SELECT item.item_name, expenditure.money, expenditure.date, expenditure.remark FROM expenditure,item WHERE expenditure.user_id = ? AND expenditure.item_id = item.item_id ORDER BY date DESC";
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
