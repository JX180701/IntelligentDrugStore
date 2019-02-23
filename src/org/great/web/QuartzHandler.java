package org.great.web;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.quartz.LibraryQuartz;
//import org.great.quartz.QuartzScheduleMgr;
import org.great.quartz.SpringDynamicCronTask;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/quartz")
public class QuartzHandler {
	
	
	@RequestMapping("auto.action")
	@ResponseBody
	public String autoExaminePass(HttpServletRequest request,String operate) throws SchedulerException, ParseException{
		SpringDynamicCronTask.cron = "0 0 0 0 0 ? ";
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				
//				SpringDynamicCronTask.cron = "0/25 * * * * ?";
//				System.err.println("cron change to: " + SpringDynamicCronTask.cron);
//			}
//		}).start();
		/*SpringDynamicCronTask sdct = new SpringDynamicCronTask();
		sdct.configureTasks(new ScheduledTaskRegistrar());
		Scheduler scheduler = QuartzScheduleMgr.getInstanceScheduler();
//		scheduler.getJobDetail(new JobKey("LibraryQuartz"));
		//判断是否有AyTestJob类，有代表任务类在执行任务，定时器已经启动了，停止它
        if(scheduler.getJobDetail(new JobKey("LibraryQuartz")) != null){
            //定时器关闭
            scheduler.deleteJob(new JobKey("LibraryQuartz"));
            System.out.println("定时器已经关闭了！！！");
            return "close";
        //没有的话，说明定时器没有启动，启动它
        }else{
            //获得定义的AyTestJob
            JobDetail myJobDetail = new JobDetailImpl("LibraryQuartz",Scheduler.DEFAULT_GROUP,LibraryQuartz.class);
            //定义出发器，每10秒触发一次
            Trigger myTrigger = new CronTriggerImpl("LibraryQuartz",Scheduler.DEFAULT_GROUP, "0/10 * * * * ?");
            //设置Job任务类和触发器
            scheduler.scheduleJob(myJobDetail, myTrigger);
            //启动定时器，大功告成！！！
            scheduler.start();
            System.out.println("每隔10秒的定时器已经启动了........");
            return "open";
        }*/
		return "open";
	}
}
