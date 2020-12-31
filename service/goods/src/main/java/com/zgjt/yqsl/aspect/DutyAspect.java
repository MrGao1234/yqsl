package com.zgjt.yqsl.aspect;

import com.zgjt.yqsl.annotation.AuthorityAnnotation;
import com.zgjt.yqsl.component.CurrentUserComponent;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.execption.ExceptionCode;
import com.zgjt.yqsl.execption.MyExecption;
import com.zgjt.yqsl.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class DutyAspect {

    @Autowired
    private CurrentUserComponent currentUserComponent;

    @Pointcut("@annotation(com.zgjt.yqsl.annotation.AuthorityAnnotation)")
    public void dataPointCut(){}

    @Around("dataPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        boolean dutyFlag = false;

        //1，获取当前登录用户
        PowerUser powerUser = currentUserComponent.findCurrentUser();

        //2, 获取注释用户权限
        //获得当前访问的class
        Class<?> className = pjp.getTarget().getClass();
        String methodName = pjp.getSignature().getName();
        Class[] argClass = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        Method method = null;
        try {
            method = className.getMethod(methodName, argClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        AuthorityAnnotation annotation = method.getAnnotation(AuthorityAnnotation.class);
        // 取出注解中的数据
        int[] dutyArray = annotation.value();
        log.info("注解的权限：{}", Arrays.toString(dutyArray));
        //不写就代表全部
        if(dutyArray == null || dutyArray.length <= 0){
            return pjp.proceed(pjp.getArgs());
        }
        //3，对比
        for(int i = 0;i < dutyArray.length;i++){
            if( dutyArray[i] == powerUser.getDuty() ){
                dutyFlag = true;
            }
        }
        //dutyFlag = ture 代表有权限，否则代表没有
        if(!dutyFlag){
            log.error("权限不足");
            return ResponseApi.error().code(ExceptionCode.DUTY_CODE);
        }
        return pjp.proceed(pjp.getArgs());
    }

}
