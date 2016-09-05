package action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bmo.IncomeBmo;
import bmo.IncomeBmoImpl;
import model.Income;

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
		}else{
			String itemName = req.getParameter("itemName");
			String remarkForItem = req.getParameter("remark");
			System.out.println(itemName);
			System.out.println(remarkForItem);
		}
		req.getRequestDispatcher("/pages/income.jsp").forward(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
