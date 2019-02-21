package org.great.entity;

//出入库明细表
public class LibraryDetail
{
	private int library_detail_id; // 出入库明细id
	private int library_id; // 药库库存id
	private String library_detail_num; // 数量
	private String library_detail_price;// 价格
	private String library_detail_date; // 时间
	private String library_detail_type; // 出库/入库/退厂
	
	private Library library;

	public LibraryDetail()
	{
		super();
	}

	public LibraryDetail(int library_detail_id, int library_id, String library_detail_num, String library_detail_price,
			String library_detail_date, String library_detail_type, Library library)
	{
		super();
		this.library_detail_id = library_detail_id;
		this.library_id = library_id;
		this.library_detail_num = library_detail_num;
		this.library_detail_price = library_detail_price;
		this.library_detail_date = library_detail_date;
		this.library_detail_type = library_detail_type;
		this.library = library;
	}

	@Override
	public String toString()
	{
		return "LibraryDetail [library_detail_id=" + library_detail_id + ", library_id=" + library_id
				+ ", library_detail_num=" + library_detail_num + ", library_detail_price=" + library_detail_price
				+ ", library_detail_date=" + library_detail_date + ", library_detail_type=" + library_detail_type
				+ ", library=" + library + "]";
	}

	public int getLibrary_detail_id()
	{
		return library_detail_id;
	}

	public void setLibrary_detail_id(int library_detail_id)
	{
		this.library_detail_id = library_detail_id;
	}

	public int getLibrary_id()
	{
		return library_id;
	}

	public void setLibrary_id(int library_id)
	{
		this.library_id = library_id;
	}

	public String getLibrary_detail_num()
	{
		return library_detail_num;
	}

	public void setLibrary_detail_num(String library_detail_num)
	{
		this.library_detail_num = library_detail_num;
	}

	public String getLibrary_detail_price()
	{
		return library_detail_price;
	}

	public void setLibrary_detail_price(String library_detail_price)
	{
		this.library_detail_price = library_detail_price;
	}

	public String getLibrary_detail_date()
	{
		return library_detail_date;
	}

	public void setLibrary_detail_date(String library_detail_date)
	{
		this.library_detail_date = library_detail_date;
	}

	public String getLibrary_detail_type()
	{
		return library_detail_type;
	}

	public void setLibrary_detail_type(String library_detail_type)
	{
		this.library_detail_type = library_detail_type;
	}

	public Library getLibrary()
	{
		return library;
	}

	public void setLibrary(Library library)
	{
		this.library = library;
	}

	
}
