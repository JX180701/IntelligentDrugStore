package org.great.biz;

import java.util.List;

import org.great.entity.Insurance;

public interface InsuranceBiz {
	public int addInsurance(Insurance insurance);
	public List<Insurance> findAllInsurance();
	public Insurance findByName(String name);
	public Insurance findById(int id);
	public int deleteById(int id);
	public int updateInsurance(Insurance insurance);
}
