package top.howie.htron.module.infra.framework.web.config;

import top.howie.htron.framework.swagger.config.HtronSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * infra 模块的 web 组件的 Configuration
 *
 * @author Howietron
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return HtronSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}
