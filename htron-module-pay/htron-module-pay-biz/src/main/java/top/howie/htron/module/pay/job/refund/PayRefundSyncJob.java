package top.howie.htron.module.pay.job.refund;

import cn.hutool.core.util.StrUtil;
import top.howie.htron.framework.quartz.core.handler.JobHandler;
import top.howie.htron.framework.tenant.core.job.TenantJob;
import top.howie.htron.module.pay.service.refund.PayRefundService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 退款订单的同步 Job
 *
 * 由于退款订单的状态，是由支付渠道异步通知进行同步，考虑到异步通知可能会失败（小概率），所以需要定时进行同步。
 *
 * @author Howietron
 */
@Component
public class PayRefundSyncJob implements JobHandler {

    @Resource
    private PayRefundService refundService;

    @Override
    @TenantJob
    public String execute(String param) {
        int count = refundService.syncRefund();
        return StrUtil.format("同步退款订单 {} 个", count);
    }

}
