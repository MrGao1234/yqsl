package com.zgjt.yqsl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.vo.PageVo;


public interface PowerUserService extends IService<PowerUser> {

    //更改店长
    int updateDirector(String shopId,int userId);

    //获取店长和员工
    IPage<PowerUser> findStaffList(PageVo pageVo);

    //自动生成员工号
    String produceAccount(PowerUser powerUser);
}
