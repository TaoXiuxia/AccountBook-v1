package bmo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Income;
import model.Item;

public interface IncomeBmo {
	
	/**
	 * 添加income
	 * @param income
	 */
	void addIncome(Income income);
	
	/**
	 * 添加Income Item
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
	List<HashMap<String, Object>> getIncomeByUserId(int userId);
	
	/**
	 * 计算总收入
	 * @return
	 */
	float getGeneralIncome(List<HashMap<String, Object>> list);
	
	/**
	 * 计算到今天为止的平均收入
	 * @return
	 */
	float getAverageIncome(float generalIncome);
}
