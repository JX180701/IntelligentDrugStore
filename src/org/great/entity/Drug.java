package org.great.entity;

//药品
public class Drug
{
	private int drug_id;
	private String drug_name1; // 商品名
	private String drug_name2; // 化学名
	private String drug_unsalable; // 自定义滞销时长
	private String drug_standard; // 规格
	private String drug_dosage; // 剂型
	private int direction_id; // 用法用量id
	private int price_id; // 价格id
	private String drug_unit1; // 药房单位
	private String drug_unit2; // 药库单位
	private String drug_formula; // 换算公式
	private String drug_special; // 是否特殊药品
	private String drug_antibiotic;// 是否抗生素
	private String drug_insurance; // 是否医保药品
	private int type_id; // 分类id
	private int drug_state; // 药品状态
	private String drug_threshold_store;//药房阈值
	private String drug_threshold_library;//药库阈值
	private int drug_sum;//库存总数

	private Direction direction;
	private Price price;
	private Type type;

	public Drug()
	{
		super();
	}

	public Drug(int drug_id, String drug_name1, String drug_name2, String drug_unsalable, String drug_standard,
			String drug_dosage, int direction_id, int price_id, String drug_unit1, String drug_unit2,
			String drug_formula, String drug_special, String drug_antibiotic, String drug_insurance, int type_id,
			int drug_state, String drug_threshold_store, String drug_threshold_library, int drug_sum,
			Direction direction, Price price, Type type) {
		super();
		this.drug_id = drug_id;
		this.drug_name1 = drug_name1;
		this.drug_name2 = drug_name2;
		this.drug_unsalable = drug_unsalable;
		this.drug_standard = drug_standard;
		this.drug_dosage = drug_dosage;
		this.direction_id = direction_id;
		this.price_id = price_id;
		this.drug_unit1 = drug_unit1;
		this.drug_unit2 = drug_unit2;
		this.drug_formula = drug_formula;
		this.drug_special = drug_special;
		this.drug_antibiotic = drug_antibiotic;
		this.drug_insurance = drug_insurance;
		this.type_id = type_id;
		this.drug_state = drug_state;
		this.drug_threshold_store = drug_threshold_store;
		this.drug_threshold_library = drug_threshold_library;
		this.drug_sum = drug_sum;
		this.direction = direction;
		this.price = price;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Drug [drug_id=" + drug_id + ", drug_name1=" + drug_name1 + ", drug_name2=" + drug_name2
				+ ", drug_unsalable=" + drug_unsalable + ", drug_standard=" + drug_standard + ", drug_dosage="
				+ drug_dosage + ", direction_id=" + direction_id + ", price_id=" + price_id + ", drug_unit1="
				+ drug_unit1 + ", drug_unit2=" + drug_unit2 + ", drug_formula=" + drug_formula + ", drug_special="
				+ drug_special + ", drug_antibiotic=" + drug_antibiotic + ", drug_insurance=" + drug_insurance
				+ ", type_id=" + type_id + ", drug_state=" + drug_state + ", drug_threshold_store="
				+ drug_threshold_store + ", drug_threshold_library=" + drug_threshold_library + ", drug_sum=" + drug_sum
				+ ", direction=" + direction + ", price=" + price + ", type=" + type + "]";
	}

	public int getDrug_id() {
		return drug_id;
	}

	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}

	public String getDrug_name1() {
		return drug_name1;
	}

	public void setDrug_name1(String drug_name1) {
		this.drug_name1 = drug_name1;
	}

	public String getDrug_name2() {
		return drug_name2;
	}

	public void setDrug_name2(String drug_name2) {
		this.drug_name2 = drug_name2;
	}

	public String getDrug_unsalable() {
		return drug_unsalable;
	}

	public void setDrug_unsalable(String drug_unsalable) {
		this.drug_unsalable = drug_unsalable;
	}

	public String getDrug_standard() {
		return drug_standard;
	}

	public void setDrug_standard(String drug_standard) {
		this.drug_standard = drug_standard;
	}

	public String getDrug_dosage() {
		return drug_dosage;
	}

	public void setDrug_dosage(String drug_dosage) {
		this.drug_dosage = drug_dosage;
	}

	public int getDirection_id() {
		return direction_id;
	}

	public void setDirection_id(int direction_id) {
		this.direction_id = direction_id;
	}

	public int getPrice_id() {
		return price_id;
	}

	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}

	public String getDrug_unit1() {
		return drug_unit1;
	}

	public void setDrug_unit1(String drug_unit1) {
		this.drug_unit1 = drug_unit1;
	}

	public String getDrug_unit2() {
		return drug_unit2;
	}

	public void setDrug_unit2(String drug_unit2) {
		this.drug_unit2 = drug_unit2;
	}

	public String getDrug_formula() {
		return drug_formula;
	}

	public void setDrug_formula(String drug_formula) {
		this.drug_formula = drug_formula;
	}

	public String getDrug_special() {
		return drug_special;
	}

	public void setDrug_special(String drug_special) {
		this.drug_special = drug_special;
	}

	public String getDrug_antibiotic() {
		return drug_antibiotic;
	}

	public void setDrug_antibiotic(String drug_antibiotic) {
		this.drug_antibiotic = drug_antibiotic;
	}

	public String getDrug_insurance() {
		return drug_insurance;
	}

	public void setDrug_insurance(String drug_insurance) {
		this.drug_insurance = drug_insurance;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getDrug_state() {
		return drug_state;
	}

	public void setDrug_state(int drug_state) {
		this.drug_state = drug_state;
	}

	public String getDrug_threshold_store() {
		return drug_threshold_store;
	}

	public void setDrug_threshold_store(String drug_threshold_store) {
		this.drug_threshold_store = drug_threshold_store;
	}

	public String getDrug_threshold_library() {
		return drug_threshold_library;
	}

	public void setDrug_threshold_library(String drug_threshold_library) {
		this.drug_threshold_library = drug_threshold_library;
	}

	public int getDrug_sum() {
		return drug_sum;
	}

	public void setDrug_sum(int drug_sum) {
		this.drug_sum = drug_sum;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


}
