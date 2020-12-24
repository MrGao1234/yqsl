package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.mapper.PowerUserMapper;
import com.zgjt.yqsl.service.PowerUserService;
import com.zgjt.yqsl.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;


@Service
public class PowerUserServiceImpl extends ServiceImpl<PowerUserMapper, PowerUser> implements PowerUserService {

    @Autowired
    private PowerUserMapper powerUserMapper;

    @Override
    public int updateDirector(String shopId, int userId) {
        return powerUserMapper.updateShopDirector(shopId,userId);
    }

    @Override
    public IPage<PowerUser> findStaffList(PageVo pageVo) {

        IPage<PowerUser> page = new Page<>(pageVo.getPageNumber(),pageVo.getPageSize());

        page.setRecords(powerUserMapper.findStaffUser(pageVo,page));

        return page;

    }

    @Override
    public String produceAccount(PowerUser powerUser) {
        int count = powerUserMapper.selectCount(null) + 1;
        String account = new DecimalFormat("0000").format(count);

        if(powerUser.getDuty() == 2){
            account = "D" + account;
        }else{
            account = "Y" + account;
        }
        return account;
    }
}
