package com.zgjt.yqsl.aop;

import com.zgjt.yqsl.annotation.DataSource;
import com.zgjt.yqsl.handler.DataSourceContextHander;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.zgjt.yqsl.annotation.DataSource)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint point) {
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHander.getDataSource();//获取当前数据源

        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@D注解
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource annotation = method.getAnnotation(DataSource.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataSourceContextHander.setDataSource(dataSource);
    }

    @After("pointCut()")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHander.clear();
    }
}
