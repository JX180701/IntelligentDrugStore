package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.entity.Library;
import org.great.entity.LibraryDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryDetailMapper
{
	public int addLibraryDetail(LibraryDetail libraryDetail);

	public List<LibraryDetail> getPsychotropicLibraryDetailList();
	
	public Library findLibraryIdByDrugNameAndBatch(Library library);
	
	public List<LibraryDetail> findAllLibraryDetail(Map map);
	
}
