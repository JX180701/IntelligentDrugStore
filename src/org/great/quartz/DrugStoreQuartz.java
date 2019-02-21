package org.great.quartz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.great.biz.DrugStoreBiz;
import org.great.biz.SellBiz;
import org.great.entity.DrugStore;
import org.great.entity.Sell;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DrugStoreQuartz  {
	
	@Resource
	private DrugStoreBiz drugstorebiz;
	@Resource
	private SellBiz sellbiz;
	@Scheduled(cron="0 0 0 1/1 * ? ")
public void Timer() {
//	System.out.println(drugstorebiz);
		String date =getTimeFormat();
		List<DrugStore> drugstoreList=drugstorebiz.findExpire(date);
		String msg="您有药品过期,药品Id为：";
		for( DrugStore d: drugstoreList){
			msg=" "+msg+d.getDrug_id()+",";
		}
		Email email=new Email();		
		if(drugstoreList.size()>0) {
			Email.content=msg;
			email.send();
		}
		
		
}
	@Scheduled(cron="0 0 0 1/1 * ? ")
	 public void unsold() {
	
		 Date date = new Date();
		 String time =getDateBefore(date,4);
		 List<Sell> list=sellbiz.unsold(time);
		 String msg="您有药品过期,药房Id为：";
		 Email email=new Email();
			for( Sell s: list){
				msg=msg+s.getDrugstore_id();
			}
			if(list.size()>0) {
				Email.content=msg;
				email.send();
			}
		
	 }
	@Scheduled(cron="0 0 0 1/1 * ? ")
	public void quartz() {
		Email.to = "1309481844@qq.com";
		Email.title = "药房低限预警";
		Email.content = "";
		List<DrugStore> thresholdList = drugstorebiz.getDrugStoreInventory();
		
		for(int i=0;i<thresholdList.size();i++) {
			DrugStore ds = thresholdList.get(i);
			int ds_threshold = Integer.parseInt(ds.getDrugstore_threshold());
			int ds_num = Integer.parseInt(ds.getDrugstore_num());
			if(ds_num<=ds_threshold) {
				Email.content += "药品"+ds.getDrug().getDrug_name1()+"已低于低限"+ds_threshold+",当前数量为："+ds_num+";\n";
			}
		}
		
		if(Email.content.length()>1) {
			Email.send();
		}
	}
	private String getTimeFormat() {
		Long l = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = formatter.format(l);
		return timeString;
	}
	
	public static String getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String timeString= sdf.format(now.getTime());
		return timeString;
		}
}
