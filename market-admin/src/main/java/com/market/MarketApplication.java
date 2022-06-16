package com.market;

import com.market.common.utils.ip.IpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序 冲突测试提交
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MarketApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(MarketApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                ",---.    ,---.   ____    .-------.    .--.   .--.      .-''-. ,---------.  \n" +
                "|    \\  /    | .'  __ `. |  _ _   \\   |  | _/  /     .'_ _   \\\\          \\ \n" +
                "|  ,  \\/  ,  |/   '  \\  \\| ( ' )  |   | (`' ) /     / ( ` )   '`--.  ,---' \n" +
                "|  |\\_   /|  ||___|  /  ||(_ o _) /   |(_ ()_)     . (_ o _)  |   |   \\    \n" +
                "|  _( )_/ |  |   _.-`   || (_,_).' __ | (_,_)   __ |  (_,_)___|   :_ _:    \n" +
                "| (_ o _) |  |.'   _    ||  |\\ \\  |  ||  |\\ \\  |  |'  \\   .---.   (_I_)    \n" +
                "|  (_,_)  |  ||  _( )_  ||  | \\ `'   /|  | \\ `'   / \\  `-'    /  (_(=)_)   \n" +
                "|  |      |  |\\ (_ o _) /|  |  \\    / |  |  \\    /   \\       /    (_I_)    \n" +
                "'--'      '--' '.(_,_).' ''-'   `'-'  `--'   `'-'     `'-..-'     '---'    \n" +
                "swagger接口地址：http://" + IpUtils.getHostIp() + ":8889/swagger-ui/index.html");
    }
}
