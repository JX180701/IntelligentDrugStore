package org.great.aop;

import javax.servlet.http.HttpSession;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.great.biz.LogBiz;
import org.great.entity.Log;
import org.great.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @desc 切面类
 */

@Aspect
@Component
public class LogAspect {

	@Resource
	LogBiz logBiz;
	
	@Pointcut("execution (* org.great.web..*.*(..))")
	public void controllerAspect() {
	}

	/**
	 * 最终增强
	 * 
	 * @param joinPoint
	 */
	@AfterReturning("controllerAspect()")
	public void afterReturn(JoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return;
		}
		try {
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			
			Object[] arguments = joinPoint.getArgs();
			Class targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String operationType = "";
			String operationName = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						if(method.getAnnotation(SystemLog.class)!=null) {
							operationType = method.getAnnotation(SystemLog.class).operationType();
							operationName = method.getAnnotation(SystemLog.class).operationName();
							break;
						}else {
							//如果方法上无日志注解，则不记录日志，直接退出方法
							return;
						}
					}
				}
			}
			
			//生成日志
			Log log = new Log();
			log.setUser_id(user.getUser_id());
			log.setLog_thing(operationType+":"+operationName);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = sdf.format(date);
			log.setLog_date(dateTime);
			// 插入数据库
			int ret = logBiz.addLog(log);
		} catch (Exception e) {
			// 日志操作异常
			throw e;
		}
	}
}
