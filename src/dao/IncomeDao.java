package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Income;
import model.Item;

public interface IncomeDao {
	
	/**
	 * 插入income
	 * @param income
	 */
	void addIncome(Income income);
	
	/**
	 * 插入income项
	 * @param incomeItem
	 */
	void addIncomeItem(Item incomeItem);
	
	/**
	 * 根据userId获取该用户的收入项（公共的项和自己创建的私有项）
	 * @param userId
	 * @return
	 */
	List<HashMap<String, Object>> getIncomeItemByUserId(int userId);
	
	/**
	 * 根据userId获取该用户的收入，具体的每一项
	 * @param userId
	 * @return
	 */
	public List<HashMap<String, Object>> getIncomeByUserId(int userId);
}
