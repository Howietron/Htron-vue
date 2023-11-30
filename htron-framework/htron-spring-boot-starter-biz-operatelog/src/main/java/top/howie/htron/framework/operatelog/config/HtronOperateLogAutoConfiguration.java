package top.howie.htron.framework.operatelog.config;

import top.howie.htron.framework.operatelog.core.aop.OperateLogAspect;
import top.howie.htron.framework.operatelog.core.service.OperateLogFrameworkService;
import top.howie.htron.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import top.howie.htron.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class HtronOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
