package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.entity.Type;
import org.great.mapper.TypeMapper;
import org.springframework.stereotype.Service;

@Service("typeBiz")
public class TypeBizImpl implements TypeBiz{

	@Resource
	private TypeMapper typeMapper;
	@Override
	public List findAllType() {
		// TODO Auto-generated method stub
		return typeMapper.findAllType();
	}
	@Override
	public Type findById(Type type) {
		// TODO Auto-generated method stub
		return typeMapper.findById(type);
	}
	@Override
	public int addType(Type type) {
		// TODO Auto-generated method stub
		return typeMapper.addType(type);
	}
	@Override
	public List<Type> findByCondition(Map map) {
		// TODO Auto-generated method stub
		return typeMapper.findByCondition(map);
	}
	@Override
	public Type findByName(String name) {
		// TODO Auto-generated method stub
		return typeMapper.findByName(name);
	}
	@Override
	public int updateType(Type type) {
		// TODO Auto-generated method stub
		return typeMapper.updateType(type);
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return typeMapper.deleteById(id);
	}

}
