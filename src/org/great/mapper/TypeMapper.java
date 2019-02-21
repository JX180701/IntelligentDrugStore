package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.entity.Type;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMapper {
	public int addType(Type type);
	public List findAllType();
	public Type findById(Type type);
	public Type findByName(String name);
	public List<Type> findByCondition(Map map);
	public int updateType(Type type);
	public int deleteById(int id);
}
