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


}
