package org.great.aop;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface SystemLog {
    /** Ҫִ�еĲ�������  **/
    public String operationType() default "";
     
    /** Ҫִ�еľ������  **/
    public String operationName() default "";
}
