package com.zgjt.yqsl.service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;

public interface VerifyService {

    //获取图片验证码
    BufferedImage getVerifyImageCode(HttpServletResponse response);

    //图片处理
    String drawRandomText(int width, int height, BufferedImage verifyImg);

    //获取随机颜色
    Color getRandomColor();
}
