package dao;

import java.util.HashMap;
import java.util.List;

import model.Expenditure;
import model.Item;

public interface ExpenditureDao {
	/**
	 * 插入expenditure
	 * @param expenditure
	 */
	void addExpenditure(Expenditure expenditure);
	
	/**
	 * 插入expenditure项
	 * @param expenditureItem
	 */
	void addExpenditureItem(Item expenditureItem);
	
	/**
	 * 根据userId获取该用户的支出项（公共的项和自己创建的私有项）
	 * @param userId
	 * @return
	 */
	List<HashMap<String, Object>> getExpenditureItemByUserId(int userId);
	
	/**
	 * 根据userId获取该用户的支出，具体的每一项
	 * @param userId
	 * @return
	 */
	public List<HashMap<String, Object>> getExpenditureByUserId(int userId);
}
