package model;

import java.util.Date;

public class Income {
	int userId;
	int itemId;
	float money;
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	Date date;
	String remark;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
