package bmo;

import dao.IncomeDao;
import dao.IncomeDaoImpl;
import model.Income;
import model.Item;

public class IncomeBmoImpl implements IncomeBmo{
	
	IncomeDao incomeDao = null;
	
	private IncomeDao getIncomeDao(){
		if(incomeDao==null){
			incomeDao = new IncomeDaoImpl();
		}
		return incomeDao;
	}
	@Override
	public void addIncome(Income income) {
		getIncomeDao().addIncome(income);
	}

	@Override
	public void addIncomeItem(Item incomeItem) {
		// TODO Auto-generated method stub
		
	}

	

}
