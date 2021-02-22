package com.zgjt.yqsl.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.zgjt.yqsl.controller.*.*(..))")
    public void dataPointCut(){}

    @Before("dataPointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        log.info( "{} 方法开始执行", signature.getMethod().getName() );
        log.info("获取参数 {}", Arrays.toString(joinPoint.getArgs()));
    }

}
