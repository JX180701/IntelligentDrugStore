package org.great.entity;

//ÅäÎé½û¼É±í
public class Taboo {

	private int 	drug_id1;
	private int 	drug_id2;
	private String 	taboo_discribe;
	
	
	public Taboo() {
		super();
	}


	public Taboo(int drug_id1, int drug_id2, String taboo_discribe) {
		super();
		this.drug_id1 = drug_id1;
		this.drug_id2 = drug_id2;
		this.taboo_discribe = taboo_discribe;
	}


	public int getDrug_id1() {
		return drug_id1;
	}


	public void setDrug_id1(int drug_id1) {
		this.drug_id1 = drug_id1;
	}


	public int getDrug_id2() {
		return drug_id2;
	}


	public void setDrug_id2(int drug_id2) {
		this.drug_id2 = drug_id2;
	}


	public String getTaboo_discribe() {
		return taboo_discribe;
	}


	public void setTaboo_discribe(String taboo_discribe) {
		this.taboo_discribe = taboo_discribe;
	}


	@Override
	public String toString() {
		return "Taboo [drug_id1=" + drug_id1 + ", drug_id2=" + drug_id2 + ", taboo_discribe=" + taboo_discribe + "]";
	}
}
