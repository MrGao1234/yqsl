package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.execption.MyExecption;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.VerifyService;
import com.zgjt.yqsl.utils.SmsUtils;
import com.zgjt.yqsl.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * 验证码controller
 * */
@Slf4j
@RestController
@RequestMapping("/sms")
public class SendMsgController {

    @Value("${sms.accessKeyId}")
    private String accessKeyId;

    @Value("${sms.accessKeySecret}")
    private String accessKeySecret;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private VerifyService verifyService;

    /*短信验证码*/
    @PostMapping("/codeSms")
    public ResponseApi sendCodeSms(@RequestParam(value = "phone") String phone){
//        System.out.println(phone);
//        String code = VerifyCodeUtils.getSixCode();
//        try {
//            if(SmsUtils.sendMessage(phone,code,accessKeyId,accessKeySecret)){
//                redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
//                return ResponseApi.sucess();
//            }
//        } catch (Exception e) {
//            log.error("发生异常",e);
//            throw new MyExecption(20001,"短信发送异常");
//        }
//        return ResponseApi.error();

        String code = VerifyCodeUtils.getSixCode();
        System.out.println(code);
        redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
        return ResponseApi.sucess();

    }

    /*图片验证码*/
    @GetMapping("/getVerifyImageCode")
    public void getVerifyImageCode(HttpServletResponse response){
        BufferedImage img = verifyService.getVerifyImageCode(response);

        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream(); //获取文件输出流
            ImageIO.write(img,"png",os);//输出图片流
            os.flush();
            os.close();
        } catch (IOException e) {
            log.info("堆栈信息",e);
        }
    }


}
