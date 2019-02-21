package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.entity.Para;
import org.springframework.stereotype.Repository;

@Repository
public interface ParaMapper {
	public int addPara(Para para);

	

	public List<Para> findallpara(Para para);

	public boolean insertpara(@Param("para")Para para);
	
	public boolean deleteparabyid(int pid);
	
	public boolean updateparabyid(Para para);

	public Para findparainfo(int pid);

	public List<Para> specificfind(Para para);

	public List<Para> finduseraut(Para para);
}
