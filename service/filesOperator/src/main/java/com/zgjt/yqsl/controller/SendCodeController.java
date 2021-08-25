package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.component.VerifyCodeComponent;
import com.zgjt.yqsl.execption.MyExecption;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.utils.ImageCodeUtil;
import com.zgjt.yqsl.utils.SendMessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * 发送验证信息
 * @author admin
 */
@Slf4j
@RestController
@RequestMapping("/verifyCode")
public class SendCodeController {

    @Value("${sms.accessKeyId}")
    private String accessKeyId;

    @Value("${sms.accessKeySecret}")
    private String accessKeySecret;

    @Autowired
    private VerifyCodeComponent verifyCodeComponent;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 短信验证码
     * */
    @PostMapping("/codeSms")
    public ResponseApi sendCodeSms(@RequestParam(value = "phone") String phone){
        log.info("输入的号码：" + phone);
        String code = ImageCodeUtil.getSixCode();
        try {
            if(SendMessageUtils.sendMessage(phone,code,accessKeyId,accessKeySecret)){
                redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
                return ResponseApi.sucess();
            }
        } catch (Exception e) {
            log.error("错误信息:" + e);
            throw new MyExecption(20001,"短信发送异常");
        }
        return ResponseApi.error();
    }


    /**
     * 图片验证码
     * */
    @GetMapping("/getVerifyImageCode")
    public void getVerifyImageCode(HttpServletResponse response){
        BufferedImage img = verifyCodeComponent.getVerifyImageCode(response);

        response.setContentType("image/png");
        try {
            //获取文件输出流
            OutputStream os = response.getOutputStream();
            //输出图片流
            ImageIO.write(img,"png",os);
            os.flush();
            os.close();
        } catch (IOException e) {
            log.info("堆栈信息",e);
        }
    }
}
