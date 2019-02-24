package org.great.web;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.quartz.LibraryQuartz;
import org.great.quartz.SpringDynamicCronTask;
import org.quartz.SchedulerException;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/quartz")
public class QuartzHandler {
	@Resource
	LibraryQuartz libraryQuartz;
	
	@RequestMapping("auto.action")
	@ResponseBody
	public String autoExaminePass(HttpServletRequest request,String operate) throws SchedulerException, ParseException{
		SpringDynamicCronTask.cron = "0/5 * * * * ?";
		
		SpringDynamicCronTask.taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				// �����߼�
				libraryQuartz.overdue();
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				// ���񴥷������޸������ִ������
				CronTrigger trigger = new CronTrigger(SpringDynamicCronTask.cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
			}
		});
		return "open";
	}
}
