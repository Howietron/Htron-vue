package top.howie.htron.module.pay.framework.web.config;

import top.howie.htron.framework.swagger.config.HtronSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * pay 模块的 web 组件的 Configuration
 *
 * @author Howietron
 */
@Configuration(proxyBeanMethods = false)
public class PayWebConfiguration {

    /**
     * pay 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi payGroupedOpenApi() {
        return HtronSwaggerAutoConfiguration.buildGroupedOpenApi("pay");
    }

}
