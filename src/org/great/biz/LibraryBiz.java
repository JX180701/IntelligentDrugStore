package org.great.biz;

import java.util.List;

import org.great.entity.Library;

public interface LibraryBiz
{
    public Library findLibraryIdByDrugNameAndBatch(Library library);
    
    public List<Library> findLibraryIdByDrugNameAndBatchList(Library library);
    
    public boolean updateLibrary(Library library);
    
    public int addLibrary(Library library);
    
    public List<Library> findAllLibrary();
    
    public int updateLibraryThreshold(String library_threshold,int library_id);
    
    public List<Library> findByOverdue(String date);
    
    public List<Library> findByDrugId(int drug_id);
}
