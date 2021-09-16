package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.utils.FilesUtil;
import com.zgjt.yqsl.utils.ImageCodeUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 生成条形码和验证码
 * @author admin
 */
@RestController
@RequestMapping("/imageCode")
public class ImageCodeController {

    /**
     * todo 条形码的 content 是有一定规则的，不能随便整
     * 条形码
     * */
    @PostMapping("/encodeBarCode")
    public void createBarCode(String content,int width, int height,  HttpServletResponse response) throws IOException {
        ServletOutputStream os = response.getOutputStream();
        BufferedImage bufferedImage = ImageCodeUtil.encodeBarcode(content, width, height);
        ImageIO.write(bufferedImage, "png", os);
        os.flush();
        os.close();
    }

    /**
     * 生成二维码图片，返回图片路径
     * content: 二维码内容
     * imagePath: 图标
     * */
    @PostMapping("/encodeQRCodeFile")
    public ResponseApi createQRCode(String content, MultipartFile imagePath) throws Exception {

        String erCode = ImageCodeUtil.encode(content, imagePath , FilesUtil.getUploadPath("erCode"), true);
        return ResponseApi.sucess().data("imageUrl", erCode);
    }

    /**
     * 生成二维码图片流
     * content: 二维码内容
     * file: logo 文件
     * */
    @PostMapping("encodeQRCodeStream")
    public ResponseApi createQRCode(String content, MultipartFile file, HttpServletResponse response) throws Exception {
        ImageCodeUtil.encode(content,file, response.getOutputStream(), true);
        return ResponseApi.sucess();
    }
}
