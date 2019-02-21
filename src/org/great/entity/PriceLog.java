package org.great.entity;

public class PriceLog
{
	private int price_log_id;
	private int drug_id;//药品id
	private String price_log_old;//原始售价
	private String price_log_new;//新售价
	private String price_log_date;//修改日期
	private String price_req_state;
	private Drug drug;
	public PriceLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PriceLog(int price_log_id, int drug_id, String price_log_old, String price_log_new, String price_log_date,
			String price_req_state, Drug drug) {
		super();
		this.price_log_id = price_log_id;
		this.drug_id = drug_id;
		this.price_log_old = price_log_old;
		this.price_log_new = price_log_new;
		this.price_log_date = price_log_date;
		this.price_req_state = price_req_state;
		this.drug = drug;
	}
	public PriceLog( int drug_id, String price_log_old, String price_log_new, String price_log_date,
			String price_req_state) {
		super();
		this.drug_id = drug_id;
		this.price_log_old = price_log_old;
		this.price_log_new = price_log_new;
		this.price_log_date = price_log_date;
		this.price_req_state = price_req_state;
	}
	public int getPrice_log_id() {
		return price_log_id;
	}
	public void setPrice_log_id(int price_log_id) {
		this.price_log_id = price_log_id;
	}
	public int getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}
	public String getPrice_log_old() {
		return price_log_old;
	}
	public void setPrice_log_old(String price_log_old) {
		this.price_log_old = price_log_old;
	}
	public String getPrice_log_new() {
		return price_log_new;
	}
	public void setPrice_log_new(String price_log_new) {
		this.price_log_new = price_log_new;
	}
	public String getPrice_log_date() {
		return price_log_date;
	}
	public void setPrice_log_date(String price_log_date) {
		this.price_log_date = price_log_date;
	}
	public String getPrice_req_state() {
		return price_req_state;
	}
	public void setPrice_req_state(String price_req_state) {
		this.price_req_state = price_req_state;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	@Override
	public String toString() {
		return "PriceLog [price_log_id=" + price_log_id + ", drug_id=" + drug_id + ", price_log_old=" + price_log_old
				+ ", price_log_new=" + price_log_new + ", price_log_date=" + price_log_date + ", price_req_state="
				+ price_req_state + ", drug=" + drug + "]";
	}
	
	
}
