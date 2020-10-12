package com.zgjt.yqsl.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaobjectHandler implements MetaObjectHandler {

    //插入数据时执行
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println(1);
        //属性名称，不是字段名称
        this.setFieldValByName("create_time",new Date(),metaObject);
        this.setFieldValByName("update_time",new Date(),metaObject);
    }

    //更新数据时执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("update_time",new Date(),metaObject);
    }
}

