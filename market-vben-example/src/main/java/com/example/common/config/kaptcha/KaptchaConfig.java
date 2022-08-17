package com.example.common.config.kaptcha;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author clf
 * @time 2022/8/12 21:47
 * @desc: KaptchaConfig
 */
@Configuration
public class KaptchaConfig {
    /**
     * 谷歌验证码属性配置
     *
     * @return
     */
    @Bean
    public Producer kaptcha() {
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "150");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "50");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
