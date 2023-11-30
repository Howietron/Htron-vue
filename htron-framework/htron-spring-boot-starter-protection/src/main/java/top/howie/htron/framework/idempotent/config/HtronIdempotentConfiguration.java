package top.howie.htron.framework.idempotent.config;

import top.howie.htron.framework.idempotent.core.aop.IdempotentAspect;
import top.howie.htron.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import top.howie.htron.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import top.howie.htron.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import top.howie.htron.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import top.howie.htron.framework.redis.config.HtronRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = HtronRedisAutoConfiguration.class)
public class HtronIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
