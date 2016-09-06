package bmo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import dao.IncomeDao;
import dao.IncomeDaoImpl;
import model.Income;
import model.Item;

public class IncomeBmoImpl implements IncomeBmo {

	IncomeDao incomeDao = null;

	private IncomeDao getIncomeDao() {
		if (incomeDao == null) {
			incomeDao = new IncomeDaoImpl();
		}
		return incomeDao;
	}

	/**
	 * 添加income
	 * 
	 * @param income
	 */
	@Override
	public void addIncome(Income income) {
		getIncomeDao().addIncome(income);
	}

	/**
	 * 添加Income Item
	 * 
	 * @param incomeItem
	 */
	@Override
	public void addIncomeItem(Item incomeItem) {
		getIncomeDao().addIncomeItem(incomeItem);
	}

	/**
	 * 根据userId获取该用户的收入项（公共的项和自己创建的私有项）
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getIncomeItemByUserId(int userId) {
		return getIncomeDao().getIncomeItemByUserId(userId);
	}
	
	/**
	 * 根据userId获取该用户的收入，具体的每一项
	 * @param userId
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getIncomeByUserId(int userId){
		return getIncomeDao().getIncomeByUserId(userId);
	}
	
	/**
	 * 计算总收入
	 * @return
	 */
	@Override
	public float getGeneralIncome(List<HashMap<String, Object>> list){
		float money=0;
		for(HashMap map :list){
			money+=(float)map.get("money");
		}
		return money;
	}
	
	/**
	 * 计算到今天为止的平均收入
	 * @return
	 */
	@Override
	public float getAverageIncome(float generalIncome){
		Calendar calendar = Calendar.getInstance();
		int days = calendar.DAY_OF_MONTH;
		float averageIncome = generalIncome/(days+1);
		return ((float)(int)(averageIncome*100))/100;
	}

}

















