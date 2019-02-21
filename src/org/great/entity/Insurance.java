package org.great.entity;

//医保药品
public class Insurance
{
	private int insurance_id; // 药品id
	private String drug_name; // 药品名
	private String insurance_code; // 医保编码

	public Insurance()
	{
		super();
	}

	public Insurance(int insurance_id, String drug_name, String insurance_code)
	{
		super();
		this.insurance_id = insurance_id;
		this.drug_name = drug_name;
		this.insurance_code = insurance_code;
	}

	public int getInsurance_id()
	{
		return insurance_id;
	}

	public void setInsurance_id(int insurance_id)
	{
		this.insurance_id = insurance_id;
	}

	public String getDrug_name()
	{
		return drug_name;
	}

	public void setDrug_name(String drug_name)
	{
		this.drug_name = drug_name;
	}

	public String getInsurance_code()
	{
		return insurance_code;
	}

	public void setInsurance_code(String insurance_code)
	{
		this.insurance_code = insurance_code;
	}

	@Override
	public String toString()
	{
		return "Insurance [insurance_id=" + insurance_id + ", drug_name=" + drug_name + ", insurance_code="
				+ insurance_code + "]";
	}
}
