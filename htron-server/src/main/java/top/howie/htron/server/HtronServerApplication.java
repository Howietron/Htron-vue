package top.howie.htron.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 *
 * 如果你碰到启动的问题，请认真阅读 https://doc.iocoder.cn/quick-start/ 文章
 * @author Howietron
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${htron.info.base-package}
@SpringBootApplication(scanBasePackages = {"${htron.info.base-package}.server", "${htron.info.base-package}.module"})
public class HtronServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtronServerApplication.class, args);
//        new SpringApplicationBuilder(HtronServerApplication.class)
//                .applicationStartup(new BufferingApplicationStartup(20480))
//                .run(args);
    }

}
