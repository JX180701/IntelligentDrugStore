package org.great.entity;

//药库
public class Library
{
	private int library_id; // 药库id

	private int drug_id; // 药品id
	private int purchase_id; // 采购统计id

	private String batch; // 批次
	private String validity; // 有效期
	private String library_num; // 数量
	private String library_threshold; // 阈值
	private String library_state; // 状态

	private Drug drug; // 药品
	private Purchase purchase; // 采购

	public Library()
	{
		super();
	}

	public Library(int library_id, int drug_id, int purchase_id, String batch, String validity, String library_num,
			String library_threshold, String library_state, Drug drug, Purchase purchase)
	{
		super();
		this.library_id = library_id;
		this.drug_id = drug_id;
		this.purchase_id = purchase_id;
		this.batch = batch;
		this.validity = validity;
		this.library_num = library_num;
		this.library_threshold = library_threshold;
		this.library_state = library_state;
		this.drug = drug;
		this.purchase = purchase;
	}

	@Override
	public String toString()
	{
		return "Library [library_id=" + library_id + ", drug_id=" + drug_id + ", purchase_id=" + purchase_id
				+ ", batch=" + batch + ", validity=" + validity + ", library_num=" + library_num
				+ ", library_threshold=" + library_threshold + ", library_state=" + library_state + ", drug=" + drug
				+ ", purchase=" + purchase + "]";
	}

	public int getLibrary_id()
	{
		return library_id;
	}

	public void setLibrary_id(int library_id)
	{
		this.library_id = library_id;
	}

	public int getDrug_id()
	{
		return drug_id;
	}

	public void setDrug_id(int drug_id)
	{
		this.drug_id = drug_id;
	}

	public int getPurchase_id()
	{
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id)
	{
		this.purchase_id = purchase_id;
	}

	public String getBatch()
	{
		return batch;
	}

	public void setBatch(String batch)
	{
		this.batch = batch;
	}

	public String getValidity()
	{
		return validity;
	}

	public void setValidity(String validity)
	{
		this.validity = validity;
	}

	public String getLibrary_num()
	{
		return library_num;
	}

	public void setLibrary_num(String library_num)
	{
		this.library_num = library_num;
	}

	public String getLibrary_threshold()
	{
		return library_threshold;
	}

	public void setLibrary_threshold(String library_threshold)
	{
		this.library_threshold = library_threshold;
	}

	public String getLibrary_state()
	{
		return library_state;
	}

	public void setLibrary_state(String library_state)
	{
		this.library_state = library_state;
	}

	public Drug getDrug()
	{
		return drug;
	}

	public void setDrug(Drug drug)
	{
		this.drug = drug;
	}

	public Purchase getPurchase()
	{
		return purchase;
	}

	public void setPurchase(Purchase purchase)
	{
		this.purchase = purchase;
	}

}
