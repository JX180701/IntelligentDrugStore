package org.great.entity;

//销售明细表
public class Sell
{

	private int sell_id; // 销售明细id
	private int drugstore_id; // 药房库存id
	private int user_id; // 人员id
	private String sell_num; // 数量
	private String sell_date; // 时间
	private String sell_price; // 销售金额
	private String drug_id;
	
	private DrugStore drugStore;
	private User user;
	private Drug drug;

	public Sell()
	{
		super();
	}

	public Sell(int sell_id, int drugstore_id, int user_id, String sell_num, String sell_date, String sell_price,
			DrugStore drugStore, User user, Drug drug) {
		super();
		this.sell_id = sell_id;
		this.drugstore_id = drugstore_id;
		this.user_id = user_id;
		this.sell_num = sell_num;
		this.sell_date = sell_date;
		this.sell_price = sell_price;
		this.drugStore = drugStore;
		this.user = user;
		this.drug = drug;
	}
	
	

	public Sell( int drugstore_id,int user_id, String sell_num, String sell_date, String sell_price, String drug_id) {
		super();
		this.drugstore_id = drugstore_id;
		this.user_id = user_id;
		this.sell_num = sell_num;
		this.sell_date = sell_date;
		this.sell_price = sell_price;
		this.drug_id = drug_id;
	}

	public int getSell_id() {
		return sell_id;
	}

	public void setSell_id(int sell_id) {
		this.sell_id = sell_id;
	}

	public int getDrugstore_id() {
		return drugstore_id;
	}

	public void setDrugstore_id(int drugstore_id) {
		this.drugstore_id = drugstore_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getSell_num() {
		return sell_num;
	}

	public void setSell_num(String sell_num) {
		this.sell_num = sell_num;
	}

	public String getSell_date() {
		return sell_date;
	}

	public void setSell_date(String sell_date) {
		this.sell_date = sell_date;
	}

	public String getSell_price() {
		return sell_price;
	}

	public void setSell_price(String sell_price) {
		this.sell_price = sell_price;
	}
	
	

	public String getDrug_id() {
		return drug_id;
	}

	public void setDrug_id(String drug_id) {
		this.drug_id = drug_id;
	}
	

	public DrugStore getDrugStore() {
		return drugStore;
	}

	public void setDrugStore(DrugStore drugStore) {
		this.drugStore = drugStore;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	

	@Override
	public String toString() {
		return "Sell [sell_id=" + sell_id + ", drugstore_id=" + drugstore_id + ", user_id=" + user_id + ", sell_num="
				+ sell_num + ", sell_date=" + sell_date + ", sell_price=" + sell_price + ", drugStore=" + drugStore
				+ ", user=" + user + ", drug=" + drug + "]";
	}

	
}
