package org.great.entity;

//采购统计表
public class Purchase
{
	private int purchase_id; // 采购统计id
	private int drug_id; // 药品id
	private int user_id; // 用户id
	private String purchase_supplier; // 供应商
	private String purchase_num; // 数量
	private String purchase_price; // 出厂单价
	private String purchase_date; // 时间
	
	
	private User user; // 用户
	private Drug drug; // 药品

	public Purchase()
	{
		super();
	}

	public Purchase(int purchase_id, int drug_id, int user_id, String purchase_supplier, String purchase_num,
			String purchase_price, String purchase_date, User user, Drug drug)
	{
		super();
		this.purchase_id = purchase_id;
		this.drug_id = drug_id;
		this.user_id = user_id;
		this.purchase_supplier = purchase_supplier;
		this.purchase_num = purchase_num;
		this.purchase_price = purchase_price;
		this.purchase_date = purchase_date;
		this.user = user;
		this.drug = drug;
	}

	@Override
	public String toString()
	{
		return "Purchase [purchase_id=" + purchase_id + ", drug_id=" + drug_id + ", user_id=" + user_id
				+ ", purchase_supplier=" + purchase_supplier + ", purchase_num=" + purchase_num + ", purchase_price="
				+ purchase_price + ", purchase_date=" + purchase_date + ", user=" + user + ", drug=" + drug + "]";
	}

	public int getPurchase_id()
	{
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id)
	{
		this.purchase_id = purchase_id;
	}

	public int getDrug_id()
	{
		return drug_id;
	}

	public void setDrug_id(int drug_id)
	{
		this.drug_id = drug_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getPurchase_supplier()
	{
		return purchase_supplier;
	}

	public void setPurchase_supplier(String purchase_supplier)
	{
		this.purchase_supplier = purchase_supplier;
	}

	public String getPurchase_num()
	{
		return purchase_num;
	}

	public void setPurchase_num(String purchase_num)
	{
		this.purchase_num = purchase_num;
	}

	public String getPurchase_price()
	{
		return purchase_price;
	}

	public void setPurchase_price(String purchase_price)
	{
		this.purchase_price = purchase_price;
	}

	public String getPurchase_date()
	{
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date)
	{
		this.purchase_date = purchase_date;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Drug getDrug()
	{
		return drug;
	}

	public void setDrug(Drug drug)
	{
		this.drug = drug;
	}

}
