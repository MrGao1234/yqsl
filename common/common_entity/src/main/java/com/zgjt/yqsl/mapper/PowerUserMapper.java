package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author admin
 */
public interface PowerUserMapper extends BaseMapper<PowerUser> {

    PowerUser findPowerUserByAccount(String account);

}
