package org.great.biz;

import java.util.List;

import org.great.entity.Para;

public interface ParaBiz
{
	

	public List<Para> findallpara(Para para);

	public boolean insertpara(Para para);

	public boolean deleteparabyid(int pid);

	public boolean updateparabyid(Para para);
	
	public Para findparainfo(int pid);

	public List<Para> specificfind(Para para);

	public List<Para> finduseraut(Para para);
}
