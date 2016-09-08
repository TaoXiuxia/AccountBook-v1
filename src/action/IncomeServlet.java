package action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bmo.IncomeBmo;
import bmo.IncomeBmoImpl;
import model.Income;
import model.Item;

public class IncomeServlet extends HttpServlet{

	IncomeBmo incomeBmo = null;
	
	private IncomeBmo getIncomeBmo(){
		if(incomeBmo==null){
			incomeBmo = new IncomeBmoImpl();
		}
		return incomeBmo;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		if("1".equals(type)){  // 1表示添加收入
			String item = req.getParameter("item");
			String money = req.getParameter("money");
			String remarkForIncome = req.getParameter("remark");

			Income income = new Income();
			income.setUserId(2); // 目前只有一个用户
			income.setItemId(Integer.parseInt(item));
			income.setMoney(Float.parseFloat(money));
			income.setDate(new Date());
			income.setRemark(remarkForIncome);
			
			getIncomeBmo().addIncome(income);
		}else if("2".equals(type)){  // 2表示添加收入项item
			String itemName = req.getParameter("itemName");
			String remarkForItem = req.getParameter("remark");
			
			Item item =new Item();
			item.setUserId(2);
			item.setIsPublic("private");  //后添加的项一定是private的，
			item.setInOrOut("in"); //收入用"in"表示
			item.setItemName(itemName);
			item.setRemark(remarkForItem);
			
			getIncomeBmo().addIncomeItem(item);
		}
		
		//收入项
		List<HashMap<String, Object>> items = getIncomeBmo().getIncomeItemByUserId(2);  //目前只有一个用户 
		req.setAttribute("items", items);
		// 具体的每一项收入
		List<HashMap<String, Object>> list = getIncomeBmo().getIncomeByUserId(2);
		req.setAttribute("list", list);
		//总收入
		float generalIncome = getIncomeBmo().getGeneralIncome(list);
		req.setAttribute("generalIncome", generalIncome);
		//日均收入
		float averageIncome = getIncomeBmo().getAverageIncome(generalIncome);
		req.setAttribute("averageIncome", averageIncome);
		req.getRequestDispatcher("/pages/income.jsp").forward(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
