package org.great.quartz;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
 
/**
 * Spring��̬���ڶ�ʱ����<br>
 * �ڲ�ͣӦ�õ�����¸�������ִ������
 * @Create 2016-11-10 16:31:29
 */
//@Lazy(false)
@Component
@EnableScheduling
public class SpringDynamicCronTask implements SchedulingConfigurer {
	
	@Resource
	LibraryQuartz libraryQuartz;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringDynamicCronTask.class);
	
	public static String cron;
	
	public SpringDynamicCronTask() {
		cron = "0 0/2 * * * ?";
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(15 * 1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				cron = "0 0/20 * * * ?";
//				System.err.println("cron change to: " + cron);
//			}
//		}).start();
	}
 
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(new Runnable() {
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
		
	}
}
