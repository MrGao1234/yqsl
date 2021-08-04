package com.zgjt.yqsl.aspect;

import com.zgjt.yqsl.vo.PageVo;
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

    @Pointcut("execution(* com.zgjt.yqsl.controller..*.*(..))")
    public void dataPointCut(){}

    @Before("dataPointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        log.info( "{} 方法开始执行", signature.getMethod().getName() );

        /*补充分页信息，放上默认值*/
        Object[] args = joinPoint.getArgs();
        log.info("获取参数 {}", Arrays.toString(args));
        for( Object arg : args ){
            if( arg.getClass().equals(PageVo.class) ){
                PageVo page = (PageVo)arg;
                page.setPageNumber(0);
                page.setPageSize(10);
            }
        }
    }

}
