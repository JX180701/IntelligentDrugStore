package org.great.biz;

import java.util.List;

import javax.annotation.Resource;
import org.great.entity.Para;
import org.great.entity.Role;
import org.great.mapper.ParaMapper;
import org.springframework.stereotype.Service;

@Service("paraBiz")
public class ParaBizImpl implements ParaBiz
{
	@Resource
	private ParaMapper paraMapper;


	

	@Override
	public List<Para>findallpara (Para para)
	{
		// TODO Auto-generated method stub
		return paraMapper.findallpara(para);
	}


	@Override
	public boolean insertpara(Para para)
	{
		// TODO Auto-generated method stub
		return paraMapper.insertpara(para);
	}
	@Override
	public boolean deleteparabyid(int pid)
	{
		// TODO Auto-generated method stub
		return paraMapper.deleteparabyid(pid);
	}
	
	@Override
	public boolean updateparabyid(Para para)
	{
		// TODO Auto-generated method stub
		return paraMapper.updateparabyid(para);
	}


	@Override
	public Para findparainfo(int pid)
	{
		// TODO Auto-generated method stub
		return paraMapper.findparainfo(pid);
	}


	@Override
	public List<Para> specificfind(Para para)
	{
		// TODO Auto-generated method stub
		return paraMapper.specificfind(para);
	}


	@Override
	public List<Para> finduseraut(Para para)
	{
		// TODO Auto-generated method stub
		return null;
	}


	


	


	
}
