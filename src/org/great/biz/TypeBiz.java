package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.entity.Type;

public interface TypeBiz {
	public List findAllType();
	public Type findById(Type type);
	public int addType(Type type);
	public Type findByName(String name);
	public List<Type> findByCondition(Map map);
	public int updateType(Type type);
	public int deleteById(int id);
}
