package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.Insurance;
import org.great.mapper.InsuranceMapper;
import org.springframework.stereotype.Service;

@Service("insuranceBiz")
public class InsuranceBizImpl implements InsuranceBiz {
	
	@Resource
	InsuranceMapper insuranceMapper;
	
	@Override
	public List<Insurance> findAllInsurance() {
		// TODO Auto-generated method stub
		return insuranceMapper.findAllInsurance();
	}

	@Override
	public Insurance findByName(String name) {
		// TODO Auto-generated method stub
		return insuranceMapper.findByName(name);
	}

	@Override
	public int addInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		return insuranceMapper.addInsurance(insurance);
	}

	@Override
	public Insurance findById(int id) {
		// TODO Auto-generated method stub
		return insuranceMapper.findById(id);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return insuranceMapper.deleteById(id);
	}

	@Override
	public int updateInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		return insuranceMapper.updateInsurance(insurance);
	}

}
