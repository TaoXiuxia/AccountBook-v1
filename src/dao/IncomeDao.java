package dao;

import model.Income;
import model.Item;

public interface IncomeDao {
	void addIncome(Income income);
	void addIncomeItem(Item IncomeItem);
}
