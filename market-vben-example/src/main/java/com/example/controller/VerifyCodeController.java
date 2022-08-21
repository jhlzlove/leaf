package com.example.controller;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;

/**
 * @author clf
 * @time 2022/8/12 21:52
 * @desc: VerifyCodeController
 */
@Api(value = "VerifyCodeController", tags = "验证码生成")
@RestController("verify")
public class VerifyCodeController {
    @Autowired
    private Producer producer;

    /**
     * 生成验证码
     *
     * @param session
     * @return
     */
    @GetMapping("vc.jpg")
    public String getVerifyCode(HttpSession session) {
        String text = producer.createText();
        session.setAttribute("kaptcha", text);
        // 生成图片
        BufferedImage bi = producer.createImage(text);
        FastByteArrayOutputStream fos = new FastByteArrayOutputStream();
        try {
            ImageIO.write(bi, "jpg", fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 返回 base64 字符串
        return Base64.getEncoder().encodeToString(fos.toByteArray());
    }
}
