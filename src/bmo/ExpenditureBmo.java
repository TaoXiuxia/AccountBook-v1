package bmo;

import java.util.HashMap;
import java.util.List;

import model.Expenditure;
import model.Income;
import model.Item;

public interface ExpenditureBmo {
	/**
	 * 添加Expenditure
	 * @param Expenditure
	 */
	void addExpenditure(Expenditure expenditure);
	
	/**
	 * 添加Expenditure Item
	 * @param ExpenditureItem
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
	List<HashMap<String, Object>> getExpenditureByUserId(int userId);
	
	/**
	 * 计算总支出
	 * @return
	 */
	float getGeneralExpenditure(List<HashMap<String, Object>> list);
	
	/**
	 * 计算到今天为止的平均支出
	 * @return
	 */
	float getAverageExpenditure(float generalExpenditure);
}
