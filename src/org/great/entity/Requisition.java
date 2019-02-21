package org.great.entity;

//申请表
public class Requisition
{
	private int requisition_id; // 申请表id
	private int user_id; // 人员id
	private int admin_id; // 审核人id
	private int drug_id; // 药品id
	private String requisition_num; // 数量
	private String requisition_state; // 申请状态
	private String requisition_date1; // 申请时间
	private String requisition_date2; // 审批时间
	private String requisition_type; // 药品请领/退库/报损
	private String requisition_discribe; // 申请描述(退库原因等)
	private String requisition_batch;// 申请批次

	private Drug drug;
	private User user;
	private User admin;

	public Requisition()
	{
		super();
	}

	public Requisition(int requisition_id, int user_id, int admin_id, int drug_id, String requisition_num,
			String requisition_state, String requisition_date1, String requisition_date2, String requisition_type,
			String requisition_discribe, String requisition_batch) {
		super();
		this.requisition_id = requisition_id;
		this.user_id = user_id;
		this.admin_id = admin_id;
		this.drug_id = drug_id;
		this.requisition_num = requisition_num;
		this.requisition_state = requisition_state;
		this.requisition_date1 = requisition_date1;
		this.requisition_date2 = requisition_date2;
		this.requisition_type = requisition_type;
		this.requisition_discribe = requisition_discribe;
		this.requisition_batch = requisition_batch;
	}
	
	

	public Requisition(int drug_id, String requisition_state, String requisition_date1, String requisition_type) {
		super();
		this.drug_id = drug_id;
		this.requisition_state = requisition_state;
		this.requisition_date1 = requisition_date1;
		this.requisition_type = requisition_type;
	}

	public Requisition(int requisition_id, int user_id, int drug_id, String requisition_num, String requisition_state,
			String requisition_date1, String requisition_type, String requisition_discribe,String requisition_batch) {
		super();
		this.requisition_id = requisition_id;
		this.user_id = user_id;
		this.drug_id = drug_id;
		this.requisition_num = requisition_num;
		this.requisition_state = requisition_state;
		this.requisition_date1 = requisition_date1;
		this.requisition_type = requisition_type;
		this.requisition_discribe = requisition_discribe;
		this.requisition_batch = requisition_batch;
	}
	public int getRequisition_id()
	{
		return requisition_id;
	}

	public void setRequisition_id(int requisition_id)
	{
		this.requisition_id = requisition_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public int getAdmin_id()
	{
		return admin_id;
	}

	public void setAdmin_id(int admin_id)
	{
		this.admin_id = admin_id;
	}

	public int getDrug_id()
	{
		return drug_id;
	}

	public void setDrug_id(int drug_id)
	{
		this.drug_id = drug_id;
	}

	public String getRequisition_num()
	{
		return requisition_num;
	}

	public void setRequisition_num(String requisition_num)
	{
		this.requisition_num = requisition_num;
	}

	public String getRequisition_state()
	{
		return requisition_state;
	}

	public void setRequisition_state(String requisition_state)
	{
		this.requisition_state = requisition_state;
	}

	public String getRequisition_date1()
	{
		return requisition_date1;
	}

	public void setRequisition_date1(String requisition_date1)
	{
		this.requisition_date1 = requisition_date1;
	}

	public String getRequisition_date2()
	{
		return requisition_date2;
	}

	public void setRequisition_date2(String requisition_date2)
	{
		this.requisition_date2 = requisition_date2;
	}

	public String getRequisition_type()
	{
		return requisition_type;
	}

	public void setRequisition_type(String requisition_type)
	{
		this.requisition_type = requisition_type;
	}

	public String getRequisition_discribe()
	{
		return requisition_discribe;
	}

	public void setRequisition_discribe(String requisition_discribe)
	{
		this.requisition_discribe = requisition_discribe;
	}

	public String getRequisition_batch()
	{
		return requisition_batch;
	}

	public void setRequisition_batch(String requisition_batch)
	{
		this.requisition_batch = requisition_batch;
	}

	public Drug getDrug()
	{
		return drug;
	}

	public void setDrug(Drug drug)
	{
		this.drug = drug;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public User getAdmin()
	{
		return admin;
	}

	public void setAdmin(User admin)
	{
		this.admin = admin;
	}

	@Override
	public String toString()
	{
		return "Requisition [requisition_id=" + requisition_id + ", user_id=" + user_id + ", admin_id=" + admin_id
				+ ", drug_id=" + drug_id + ", requisition_num=" + requisition_num + ", requisition_state="
				+ requisition_state + ", requisition_date1=" + requisition_date1 + ", requisition_date2="
				+ requisition_date2 + ", requisition_type=" + requisition_type + ", requisition_discribe="
				+ requisition_discribe + ", requisition_batch=" + requisition_batch + ", drug=" + drug + ", user="
				+ user + ", admin=" + admin + "]";
	}

}
