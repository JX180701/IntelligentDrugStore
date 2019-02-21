package org.great.entity;

//分类表
public class Type {

	private int type_id;	
	private int type_pid;	//分类父id
	private String type_name;	//分类名
	
	public Type() {
		super();
	}

	public Type(int type_id, int type_pid, String type_name) {
		super();
		this.type_id = type_id;
		this.type_pid = type_pid;
		this.type_name = type_name;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getType_pid() {
		return type_pid;
	}

	public void setType_pid(int type_pid) {
		this.type_pid = type_pid;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	@Override
	public String toString() {
		return "Type [type_id=" + type_id + ", type_pid=" + type_pid + ", type_name=" + type_name + "]";
	}
}
