package action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bmo.ExpenditureBmo;
import bmo.ExpenditureBmoImpl;
import model.Expenditure;
import model.Item;

public class ExpenditureServlet extends HttpServlet{

	ExpenditureBmo expenditureBmo = null;
	
	private ExpenditureBmo getExpenditureBmo(){
		if(expenditureBmo==null){
			expenditureBmo = new ExpenditureBmoImpl();
		}
		return expenditureBmo;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		if("1".equals(type)){  // 1表示添加支出
			String item = req.getParameter("item");
			String money = req.getParameter("money");
			String remarkForIncome = req.getParameter("remark");

			Expenditure Expenditure = new Expenditure();
			Expenditure.setUserId(2); // 目前只有一个用户
			Expenditure.setItemId(Integer.parseInt(item));
			Expenditure.setMoney(Float.parseFloat(money));
			Expenditure.setDate(new Date());
			Expenditure.setRemark(remarkForIncome);
			
			getExpenditureBmo().addExpenditure(Expenditure);
		}else if("2".equals(type)){  // 2表示添加支出项item
			String itemName = req.getParameter("itemName");
			String remarkForItem = req.getParameter("remark");
			
			Item item =new Item();
			item.setUserId(2);
			item.setIsPublic("private");  //后添加的项一定是private的，
			item.setInOrOut("out"); //支出用"out"表示
			item.setItemName(itemName);
			item.setRemark(remarkForItem);
			
			getExpenditureBmo().addExpenditureItem(item);
		}
		
		//支出项
		List<HashMap<String, Object>> items = getExpenditureBmo().getExpenditureItemByUserId(2);  //目前只有一个用户 
		req.setAttribute("items", items);
		// 具体的每一项支出
		List<HashMap<String, Object>> list = getExpenditureBmo().getExpenditureByUserId(2);
		req.setAttribute("list", list);
		//总支出
		float generalExpenditure = getExpenditureBmo().getGeneralExpenditure(list);
		req.setAttribute("generalExpenditure", generalExpenditure);
		//日均支出
		float averageExpenditure = getExpenditureBmo().getAverageExpenditure(generalExpenditure);
		req.setAttribute("averageExpenditure", averageExpenditure);
		req.getRequestDispatcher("/pages/expenditure.jsp").forward(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
