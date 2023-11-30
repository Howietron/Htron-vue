package top.howie.htron.module.pay.dal.redis.notify;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static top.howie.htron.module.pay.dal.redis.RedisKeyConstants.PAY_NOTIFY_LOCK;

/**
 * 支付通知的锁 Redis DAO
 *
 * @author Howietron
 */
@Repository
public class PayNotifyLockRedisDAO {

    @Resource
    private RedissonClient redissonClient;

    public void lock(Long id, Long timeoutMillis, Runnable runnable) {
        String lockKey = formatKey(id);
        RLock lock = redissonClient.getLock(lockKey);
        try {
            lock.lock(timeoutMillis, TimeUnit.MILLISECONDS);
            // 执行逻辑
            runnable.run();
        } finally {
            lock.unlock();
        }
    }

    private static String formatKey(Long id) {
        return String.format(PAY_NOTIFY_LOCK, id);
    }

}
