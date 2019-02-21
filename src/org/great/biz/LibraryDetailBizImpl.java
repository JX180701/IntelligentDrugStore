package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.entity.Library;
import org.great.entity.LibraryDetail;
import org.great.mapper.LibraryDetailMapper;
import org.springframework.stereotype.Service;

@Service("libraryDetailBiz")
public class LibraryDetailBizImpl implements LibraryDetailBiz
{
	@Resource
	LibraryDetailMapper libraryDetailMapper;

	@Override
	public List<LibraryDetail> getPsychotropicLibraryDetailList()
	{
		return libraryDetailMapper.getPsychotropicLibraryDetailList();
	}

	@Override
	public int addLibraryDetail(LibraryDetail libraryDetail)
	{
		return libraryDetailMapper.addLibraryDetail(libraryDetail);
	}

	@Override
	public List<LibraryDetail> findAllLibraryDetail(Map map)
	{
		return libraryDetailMapper.findAllLibraryDetail(map);
	}

}
