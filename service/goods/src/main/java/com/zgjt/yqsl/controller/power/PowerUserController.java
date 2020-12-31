package com.zgjt.yqsl.controller.power;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zgjt.yqsl.annotation.AuthorityAnnotation;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.PowerUserService;
import com.zgjt.yqsl.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/powerUser")
public class PowerUserController {

    @Autowired
    private PowerUserService powerUserService;

    //店长列表
    @AuthorityAnnotation(value = {1})
    @GetMapping("directorList")
    public ResponseApi findDirectorList(){
        QueryWrapper<PowerUser> wrapper = new QueryWrapper<>();
        wrapper.eq("duty",2);
        wrapper.eq("shop_id",1);
        return ResponseApi.sucess().put(powerUserService.list(wrapper));
    }

    //更换店长
    @AuthorityAnnotation(value = {1})
    @PostMapping("updateDirector")
    @Transactional
    public ResponseApi updateDirector(String shopId,int oldUserId,int newUserId){
        powerUserService.updateDirector("1",oldUserId);
        powerUserService.updateDirector(shopId,newUserId);
        return ResponseApi.sucess();
    }

    //查询店长和员工
    @AuthorityAnnotation(value = {1,2})
    @PostMapping("/staffList")
    public ResponseApi findStaffList(@RequestBody PageVo pageVo){
        return ResponseApi.sucess().put(powerUserService.findStaffList(pageVo));
    }

    //添加员工(捎带着登录)
    @AuthorityAnnotation(value = {2})
    @PostMapping("/addStaff")
    public ResponseApi addStaff(@RequestBody PowerUser powerUser){

        if(powerUser.getDuty() == 2 || powerUser.getDuty() == 3){

            //账号系统生成
            powerUser.setAccount(powerUserService.produceAccount(powerUser));
            powerUser.setUserPwd(DigestUtils.md5DigestAsHex( powerUser.getAccount().getBytes() ));
        }else{
            //账号自己起，不能纯数字
            powerUser.setUserPwd(DigestUtils.md5DigestAsHex( powerUser.getUserPwd().getBytes() ));
        }
        powerUser.setStatus("0");
        powerUser.setShopId("1");

        powerUserService.save(powerUser);
        return ResponseApi.sucess();
    }

    //删除员工
    @AuthorityAnnotation(value = {2})
    @PostMapping("removeStaff")
    public ResponseApi removeStaff(int id){
        powerUserService.removeById(id);
        return ResponseApi.sucess();
    }

    //更新员工
    @AuthorityAnnotation(value = {2})
    @PostMapping("/updateStaff")
    public ResponseApi updateStaff(@RequestBody PowerUser powerUser){
        powerUserService.updateById(powerUser);
        return ResponseApi.sucess();
    }



}
