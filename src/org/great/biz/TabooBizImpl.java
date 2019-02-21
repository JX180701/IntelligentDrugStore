package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.Taboo;
import org.great.mapper.TabooMapper;
import org.springframework.stereotype.Service;

@Service("tabooBiz")
public class TabooBizImpl implements TabooBiz {
	
	@Resource
	TabooMapper tabooMapper;
	
	@Override
	public int addTaboo(Taboo taboo) {
		// TODO Auto-generated method stub
		return tabooMapper.addTaboo(taboo);
	}

	@Override
	public List<Taboo> findAllTaboo() {
		// TODO Auto-generated method stub
		return tabooMapper.findAllTaboo();
	}

	@Override
	public Taboo findByDiscribe(String taboo_discribe) {
		// TODO Auto-generated method stub
		return tabooMapper.findByDiscribe(taboo_discribe);
	}

	@Override
	public int updateTaboo(Taboo taboo) {
		// TODO Auto-generated method stub
		return tabooMapper.updateTaboo(taboo);
	}

	@Override
	public Taboo findByOption(Taboo taboo) {
		// TODO Auto-generated method stub
		return tabooMapper.findByOption(taboo);
	}

	@Override
	public int deleteTaboo(Taboo taboo) {
		// TODO Auto-generated method stub
		return tabooMapper.deleteTaboo(taboo);
	}

	@Override
	public List<Taboo> searchConditionTaboo(int drug_id) {
		// TODO Auto-generated method stub
		return tabooMapper.searchConditionTaboo(drug_id);
	}
	
	@Override
	public List<Taboo> findTaboo(String id) {
		// TODO Auto-generated method stub
		return tabooMapper.showTaboo(id);
	}

}
