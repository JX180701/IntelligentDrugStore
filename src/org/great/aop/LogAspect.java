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
 * @desc ������
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
	 * ������ǿ
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
							//�������������־ע�⣬�򲻼�¼��־��ֱ���˳�����
							return;
						}
					}
				}
			}
			
			//������־
			Log log = new Log();
			log.setUser_id(user.getUser_id());
			log.setLog_thing(operationType+":"+operationName);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = sdf.format(date);
			log.setLog_date(dateTime);
			// �������ݿ�
			int ret = logBiz.addLog(log);
		} catch (Exception e) {
			// ��־�����쳣
			throw e;
		}
	}
}
