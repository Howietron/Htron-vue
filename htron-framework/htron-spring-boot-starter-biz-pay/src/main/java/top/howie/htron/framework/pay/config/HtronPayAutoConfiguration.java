package top.howie.htron.framework.pay.config;

import top.howie.htron.framework.pay.core.client.PayClientFactory;
import top.howie.htron.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author Howietron
 */
@AutoConfiguration
public class HtronPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
