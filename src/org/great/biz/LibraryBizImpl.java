package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.Library;
import org.great.mapper.LibraryMapper;
import org.springframework.stereotype.Service;

@Service("libraryBiz")
public class LibraryBizImpl implements LibraryBiz
{
	@Resource
	LibraryMapper libraryMapper;
	
	@Override
	public Library findLibraryIdByDrugNameAndBatch(Library library)
	{
		return libraryMapper.findLibraryIdByDrugNameAndBatch(library);
	}

	@Override
	public List<Library> findLibraryIdByDrugNameAndBatchList(Library library)
	{
		return libraryMapper.findLibraryIdByDrugNameAndBatchList(library);
	}

	@Override
	public boolean updateLibrary(Library library)
	{
		return libraryMapper.updateLibrary(library);
	}

	@Override
	public List<Library> findAllLibrary() {
		// TODO Auto-generated method stub
		return libraryMapper.findAllLibrary();
	}
	
	@Override
	public int addLibrary(Library library)
	{
		// TODO Auto-generated method stub
		return libraryMapper.addLibrary(library);
	}

	@Override
	public int updateLibraryThreshold(String library_threshold, int library_id) {
		// TODO Auto-generated method stub
		return libraryMapper.updateLibraryThreshold(library_threshold, library_id);
	}

	@Override
	public List<Library> findByOverdue(String date) {
		// TODO Auto-generated method stub
		return libraryMapper.findByOverdue(date);
	}

	@Override
	public List<Library> findByDrugId(int drug_id) {
		// TODO Auto-generated method stub
		return libraryMapper.findByDrugId(drug_id);
	}

}
