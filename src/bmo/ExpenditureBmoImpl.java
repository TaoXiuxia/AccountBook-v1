package bmo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import dao.ExpenditureDao;
import dao.ExpenditureDaoImpl;
import dao.IncomeDao;
import dao.IncomeDaoImpl;
import model.Expenditure;
import model.Income;
import model.Item;

public class ExpenditureBmoImpl implements ExpenditureBmo {
	
	ExpenditureDao expenditureDao = null;

	private ExpenditureDao getExpenditureDao() {
		if (expenditureDao == null) {
			expenditureDao = new ExpenditureDaoImpl();
		}
		return expenditureDao;
	}

	/**
	 * 添加Expenditure
	 * 
	 * @param expenditure
	 */
	@Override
	public void addExpenditure(Expenditure expenditure) {
		getExpenditureDao().addExpenditure(expenditure);
	}

	/**
	 * 添加Expenditure Item
	 * 
	 * @param expenditureItem
	 */
	@Override
	public void addExpenditureItem(Item expenditureItem) {
		getExpenditureDao().addExpenditureItem(expenditureItem);
	}

	/**
	 * 根据userId获取该用户的支出项（公共的项和自己创建的私有项）
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getExpenditureItemByUserId(int userId) {
		return getExpenditureDao().getExpenditureItemByUserId(userId);
	}
	
	/**
	 * 根据userId获取该用户的支出，具体的每一项
	 * @param userId
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getExpenditureByUserId(int userId){
		return getExpenditureDao().getExpenditureByUserId(userId);
	}
	
	/**
	 * 计算总支出
	 * @return
	 */
	@Override
	public float getGeneralExpenditure(List<HashMap<String, Object>> list){
		float money=0;
		for(HashMap map :list){
			money+=(float)map.get("money");
		}
		return money;
	}
	
	/**
	 * 计算到今天为止的平均支出
	 * @return
	 */
	@Override
	public float getAverageExpenditure(float generalExpenditure){
		Calendar calendar = Calendar.getInstance();
		int days = calendar.DAY_OF_MONTH;
		float averageExpenditure = generalExpenditure/(days+1);
		return ((float)(int)(averageExpenditure*100))/100;
	}

}
