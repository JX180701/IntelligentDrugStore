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
		//�ж��Ƿ���AyTestJob�࣬�д�����������ִ�����񣬶�ʱ���Ѿ������ˣ�ֹͣ��
        if(scheduler.getJobDetail(new JobKey("LibraryQuartz")) != null){
            //��ʱ���ر�
            scheduler.deleteJob(new JobKey("LibraryQuartz"));
            System.out.println("��ʱ���Ѿ��ر��ˣ�����");
            return "close";
        //û�еĻ���˵����ʱ��û��������������
        }else{
            //��ö����AyTestJob
            JobDetail myJobDetail = new JobDetailImpl("LibraryQuartz",Scheduler.DEFAULT_GROUP,LibraryQuartz.class);
            //�����������ÿ10�봥��һ��
            Trigger myTrigger = new CronTriggerImpl("LibraryQuartz",Scheduler.DEFAULT_GROUP, "0/10 * * * * ?");
            //����Job������ʹ�����
            scheduler.scheduleJob(myJobDetail, myTrigger);
            //������ʱ�����󹦸�ɣ�����
            scheduler.start();
            System.out.println("ÿ��10��Ķ�ʱ���Ѿ�������........");
            return "open";
        }*/
		return "open";
	}
}
