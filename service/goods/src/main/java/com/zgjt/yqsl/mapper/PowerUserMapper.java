package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PowerUserMapper extends BaseMapper<PowerUser> {

    @Update("update power_user set shop_id = #{shopId} where id = #{userId}")
    int updateShopDirector(String shopId, int userId);

    //查询员工和店长
    List<PowerUser> findStaffUser(@Param("pageVo") PageVo pageVo, IPage<PowerUser> page);


}
