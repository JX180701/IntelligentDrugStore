package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.entity.LibraryDetail;

public interface LibraryDetailBiz
{
	public List<LibraryDetail> getPsychotropicLibraryDetailList();
	
	public int addLibraryDetail(LibraryDetail libraryDetail);
	
	public List<LibraryDetail> findAllLibraryDetail(Map map);
}
