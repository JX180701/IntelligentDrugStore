package org.great.biz;

import java.util.List;

import org.great.entity.Taboo;

public interface TabooBiz {
	public int addTaboo(Taboo taboo);
	public List<Taboo> findAllTaboo();
	public Taboo findByDiscribe(String taboo_discribe);
	public int updateTaboo(Taboo taboo);
	public Taboo findByOption(Taboo taboo);
	public int deleteTaboo(Taboo taboo);
	public List<Taboo> searchConditionTaboo(int drug_id);
	public List<Taboo> findTaboo(String id);
}
