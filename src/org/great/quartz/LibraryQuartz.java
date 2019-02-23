package org.great.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.great.biz.DrugBiz;
import org.great.biz.DrugBizImpl;
import org.great.biz.LibraryBiz;
import org.great.biz.LibraryBizImpl;
import org.great.entity.Drug;
import org.great.entity.Library;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LibraryQuartz{
	@Resource
	LibraryBiz libraryBiz;

	@Resource
	DrugBiz drugBiz;

//	@Scheduled(cron="0/20 * * * * ? ")
//	@Scheduled(cron="0 0 0 1/1 * ? ")
	public void quartz() {
		
		Email.to = "1309481844@qq.com";
		Email.title = "药库低限预警";
		Email.content = "";
		List<Drug> drugList = drugBiz.findAllDrug();
		for (int i = 0; i < drugList.size(); i++) {
			Drug drug = drugList.get(i);
			String xx = drug.getDrug_threshold_library();
			String ww = drug.getDrug_name1();
			int threshold = Integer.valueOf(xx);
			System.out.println("threshold" + threshold);
			int count = 0;
			List<Library> libraryList = libraryBiz.findByDrugId(drug.getDrug_id());
			for (int j = 0; j < libraryList.size(); j++) {
				Library library = libraryList.get(j);
				count += Integer.valueOf(library.getLibrary_num());
			}
			if (count < threshold) {
				Email.content += "药品" + drug.getDrug_name1() + "已低于低限" + threshold + ",当前数量为：" + count + ";\n";
			}
		}

		if (Email.content.length() > 1) {
			Email.send();
		}
	}

//	@Scheduled(cron="0/20 * * * * ? ")
//	@Scheduled(cron="0 0 0 1/1 * ? ")
	public void overdue() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateTime = sdf.format(date);
		List<Library> libraryList = libraryBiz.findByOverdue(dateTime);
		if (libraryList.size() > 0) {
			Email.to = "1309481844@qq.com";
			Email.title = "药库过期预警";
			Email.content = "";
			for (int i = 0; i < libraryList.size(); i++) {
				Library library = libraryList.get(i);
				Email.content += "批次" + library.getValidity() + "的药品" + library.getDrug().getDrug_name1() + "已过期"
						+ ",其有效期为：" + library.getValidity() + ";\n";
			}
			Email.send();
			System.out.println(date);
		}
	}
}
