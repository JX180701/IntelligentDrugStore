package org.great.entity;

//ҩ��
public class DrugStore
{
	private int drugstore_id; // ҩ�����id
	private int drug_id; // ҩƷid
	private int purchase_id; // �ɹ�ͳ��id
	private String batch; // ����
	private String validity; // ��Ч��
	private String drugstore_num; // ����
	private String drugstore_threshold;// ��ֵ
	private String drugstore_balance;//ӯ�� 
	private String drugstore_state; // ״̬
	private Drug drug;
	private Purchase purchase;

	public DrugStore()
	{
		super();
	}

	public DrugStore(int drugstore_id, int drug_id, int purchase_id, String batch, String validity,
			String drugstore_num, String drugstore_threshold, String drugstore_state, Drug drug, Purchase purchase,String drugstore_balance) {
		super();
		this.drugstore_id = drugstore_id;
		this.drug_id = drug_id;
		this.purchase_id = purchase_id;
		this.batch = batch;
		this.validity = validity;
		this.drugstore_num = drugstore_num;
		this.drugstore_threshold = drugstore_threshold;
		this.drugstore_state = drugstore_state;
		this.drug = drug;
		this.purchase = purchase;
		this.drugstore_balance=drugstore_balance;
	}

	public int getDrugstore_id() {
		return drugstore_id;
	}

	public void setDrugstore_id(int drugstore_id) {
		this.drugstore_id = drugstore_id;
	}

	public int getDrug_id() {
		return drug_id;
	}

	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getDrugstore_num() {
		return drugstore_num;
	}

	public void setDrugstore_num(String drugstore_num) {
		this.drugstore_num = drugstore_num;
	}

	public String getDrugstore_threshold() {
		return drugstore_threshold;
	}

	public void setDrugstore_threshold(String drugstore_threshold) {
		this.drugstore_threshold = drugstore_threshold;
	}

	public String getDrugstore_state() {
		return drugstore_state;
	}

	public void setDrugstore_state(String drugstore_state) {
		this.drugstore_state = drugstore_state;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	@Override
	public String toString() {
		return "DrugStore [drugstore_id=" + drugstore_id + ", drug_id=" + drug_id + ", purchase_id=" + purchase_id
				+ ", batch=" + batch + ", validity=" + validity + ", drugstore_num=" + drugstore_num
				+ ", drugstore_threshold=" + drugstore_threshold + ", drugstore_state=" + drugstore_state + ", drug="
				+ drug + ", purchase=" + purchase + "]";
	}

	public String getDrugstore_balance() {
		return drugstore_balance;
	}

	public void setDrugstore_balance(String drugstore_balance) {
		this.drugstore_balance = drugstore_balance;
	}


}
