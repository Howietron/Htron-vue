package top.howie.htron.framework.file.config;

import top.howie.htron.framework.file.core.client.FileClientFactory;
import top.howie.htron.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author Howietron
 */
@AutoConfiguration
public class HtronFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
