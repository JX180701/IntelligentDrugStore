package org.great.entity;

//�۸��
public class Price
{
	private int price_id;
	private String price_cost; // �ɱ�
	private String price_retail; // ���ۼ�
	private String price_ratio; // �ӳ���
	private String price_floor; // �׼�
	private String price_invoice; // ��Ʊ��
	private String price_settle; // ʵ�ʽ����

	public Price()
	{
		super();
	}
	
	

	public Price(int price_id, String price_retail) {
		super();
		this.price_id = price_id;
		this.price_retail = price_retail;
	}



	public Price(int price_id, String price_cost, String price_retail, String price_ratio, String price_floor,
			String price_invoice, String price_settle)
	{
		super();
		this.price_id = price_id;
		this.price_cost = price_cost;
		this.price_retail = price_retail;
		this.price_ratio = price_ratio;
		this.price_floor = price_floor;
		this.price_invoice = price_invoice;
		this.price_settle = price_settle;
	}

	public int getPrice_id()
	{
		return price_id;
	}

	public void setPrice_id(int price_id)
	{
		this.price_id = price_id;
	}

	public String getPrice_cost()
	{
		return price_cost;
	}

	public void setPrice_cost(String price_cost)
	{
		this.price_cost = price_cost;
	}

	public String getPrice_retail()
	{
		return price_retail;
	}

	public void setPrice_retail(String price_retail)
	{
		this.price_retail = price_retail;
	}

	public String getPrice_ratio()
	{
		return price_ratio;
	}

	public void setPrice_ratio(String price_ratio)
	{
		this.price_ratio = price_ratio;
	}

	public String getPrice_floor()
	{
		return price_floor;
	}

	public void setPrice_floor(String price_floor)
	{
		this.price_floor = price_floor;
	}

	public String getPrice_invoice()
	{
		return price_invoice;
	}

	public void setPrice_invoice(String price_invoice)
	{
		this.price_invoice = price_invoice;
	}

	public String getPrice_settle()
	{
		return price_settle;
	}

	public void setPrice_settle(String price_settle)
	{
		this.price_settle = price_settle;
	}

	@Override
	public String toString()
	{
		return "Price [price_id=" + price_id + ", price_cost=" + price_cost + ", price_retail=" + price_retail
				+ ", price_ratio=" + price_ratio + ", price_floor=" + price_floor + ", price_invoice=" + price_invoice
				+ ", price_settle=" + price_settle + "]";
	}

}
