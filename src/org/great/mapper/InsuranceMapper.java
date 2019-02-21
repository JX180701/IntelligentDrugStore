package org.great.mapper;

import java.util.List;

import org.great.entity.Insurance;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceMapper {
	public int addInsurance(Insurance insurance);
	public List<Insurance> findAllInsurance();
	public Insurance findByName(String name);
	public Insurance findById(int id);
	public int deleteById(int id);
	public int updateInsurance(Insurance insurance);
}
