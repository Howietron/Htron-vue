package top.howie.htron.framework.sms.config;

import top.howie.htron.framework.sms.core.client.SmsClientFactory;
import top.howie.htron.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 短信配置类
 *
 * @author Howietron
 */
@AutoConfiguration
public class HtronSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
