package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.utils.FilesUtil;
import com.zgjt.yqsl.utils.ImageCodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 生成条形码和验证码
 * @author admin
 */
@RestController
@RequestMapping("/imageCode")
public class ImageCodeController {

    @RequestMapping("/encodeBarCode")
    public void createBarCode(String content,int width, int height,  HttpServletResponse response) throws IOException {
        ServletOutputStream os = response.getOutputStream();
        BufferedImage bufferedImage = ImageCodeUtil.encodeBarcode(content, width, height);
        ImageIO.write(bufferedImage, "png", os);
        os.flush();
        os.close();
    }

    @RequestMapping("/encodeQRCodeFile")
    public ResponseApi createQRCode(String content, String imagePath) throws Exception {
        String erCode = ImageCodeUtil.encode(content, imagePath , FilesUtil.getUploadPath("erCode"), true);
        return ResponseApi.sucess().data("imageUrl", erCode);
    }

    @RequestMapping("encodeQRCodeStream")
    public ResponseApi createQRCode(String content, HttpServletResponse response) throws Exception {
        ImageCodeUtil.encode(content, response.getOutputStream());
        return ResponseApi.sucess();
    }
}
