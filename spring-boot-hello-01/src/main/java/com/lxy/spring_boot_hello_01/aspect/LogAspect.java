package com.lxy.spring_boot_hello_01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LogAspect {

	private Logger logger = LoggerFactory.getLogger(LogAspect.class);
	private ObjectMapper objectMapper = new ObjectMapper();	
	
	@Pointcut("execution(public * com.lxy.spring_boot_hello_01.controller..*.*(..))")
    public void pointcut(){}
	
	@Before("pointcut()")
    public void printParam(JoinPoint joinPoint){
        //获取请求的方法
        Signature sig = joinPoint.getSignature();
        String method = joinPoint.getTarget().getClass().getName() + "." + sig.getName();

        //获取请求的参数
        Object[] args = joinPoint.getArgs();
        
        try {
        	String params = objectMapper.writeValueAsString(args);
        	//打印请求参数
            logger.info(method + ":" + params);
        } catch (Exception e) {
			// TODO: handle exception
        	logger.error("异常信息：{}", e);
		}
    }
	
	
	// 定义切点。将AOP和自定义注解进行结合的关键所在
    @Pointcut("@annotation(LogAnnotation)")
    public void annotationPointCut() {
    }   
    
    @Before("annotationPointCut()")
    public void printParamAnno(JoinPoint joinPoint){
        //获取请求的方法
        Signature sig = joinPoint.getSignature();
        String method = joinPoint.getTarget().getClass().getName() + "." + sig.getName();

        //获取请求的参数
        Object[] args = joinPoint.getArgs();
        
        try {
        	String params = objectMapper.writeValueAsString(args);
        	//打印请求参数
            logger.info("annotation aop " + method + ":" + params);
        } catch (Exception e) {
			// TODO: handle exception
        	logger.error("异常信息：{}", e);
		}
    }
}
