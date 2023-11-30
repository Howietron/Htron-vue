package top.howie.htron.module.pay.controller.admin.notify;

import cn.hutool.core.collection.CollUtil;
import top.howie.htron.framework.common.pojo.CommonResult;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.framework.operatelog.core.annotations.OperateLog;
import top.howie.htron.framework.pay.core.client.PayClient;
import top.howie.htron.framework.pay.core.client.dto.order.PayOrderRespDTO;
import top.howie.htron.framework.pay.core.client.dto.refund.PayRefundRespDTO;
import top.howie.htron.module.pay.controller.admin.notify.vo.PayNotifyTaskDetailRespVO;
import top.howie.htron.module.pay.controller.admin.notify.vo.PayNotifyTaskPageReqVO;
import top.howie.htron.module.pay.controller.admin.notify.vo.PayNotifyTaskRespVO;
import top.howie.htron.module.pay.convert.notify.PayNotifyTaskConvert;
import top.howie.htron.module.pay.dal.dataobject.app.PayAppDO;
import top.howie.htron.module.pay.dal.dataobject.notify.PayNotifyLogDO;
import top.howie.htron.module.pay.dal.dataobject.notify.PayNotifyTaskDO;
import top.howie.htron.module.pay.service.app.PayAppService;
import top.howie.htron.module.pay.service.channel.PayChannelService;
import top.howie.htron.module.pay.service.notify.PayNotifyService;
import top.howie.htron.module.pay.service.order.PayOrderService;
import top.howie.htron.module.pay.service.refund.PayRefundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static top.howie.htron.framework.common.exception.util.ServiceExceptionUtil.exception;
import static top.howie.htron.framework.common.pojo.CommonResult.success;
import static top.howie.htron.framework.common.util.collection.CollectionUtils.convertList;
import static top.howie.htron.module.pay.enums.ErrorCodeConstants.CHANNEL_NOT_FOUND;

@Tag(name = "管理后台 - 回调通知")
@RestController
@RequestMapping("/pay/notify")
@Validated
@Slf4j
public class PayNotifyController {

    @Resource
    private PayOrderService orderService;
    @Resource
    private PayRefundService refundService;
    @Resource
    private PayNotifyService notifyService;
    @Resource
    private PayAppService appService;
    @Resource
    private PayChannelService channelService;

    @PostMapping(value = "/order/{channelId}")
    @Operation(summary = "支付渠道的统一【支付】回调")
    @PermitAll
    @OperateLog(enable = false) // 回调地址，无需记录操作日志
    public String notifyOrder(@PathVariable("channelId") Long channelId,
                              @RequestParam(required = false) Map<String, String> params,
                              @RequestBody(required = false) String body) {
        log.info("[notifyOrder][channelId({}) 回调数据({}/{})]", channelId, params, body);
        // 1. 校验支付渠道是否存在
        PayClient payClient = channelService.getPayClient(channelId);
        if (payClient == null) {
            log.error("[notifyCallback][渠道编号({}) 找不到对应的支付客户端]", channelId);
            throw exception(CHANNEL_NOT_FOUND);
        }

        // 2. 解析通知数据
        PayOrderRespDTO notify = payClient.parseOrderNotify(params, body);
        orderService.notifyOrder(channelId, notify);
        return "success";
    }

    @PostMapping(value = "/refund/{channelId}")
    @Operation(summary = "支付渠道的统一【退款】回调")
    @PermitAll
    @OperateLog(enable = false) // 回调地址，无需记录操作日志
    public String notifyRefund(@PathVariable("channelId") Long channelId,
                              @RequestParam(required = false) Map<String, String> params,
                              @RequestBody(required = false) String body) {
        log.info("[notifyRefund][channelId({}) 回调数据({}/{})]", channelId, params, body);
        // 1. 校验支付渠道是否存在
        PayClient payClient = channelService.getPayClient(channelId);
        if (payClient == null) {
            log.error("[notifyCallback][渠道编号({}) 找不到对应的支付客户端]", channelId);
            throw exception(CHANNEL_NOT_FOUND);
        }

        // 2. 解析通知数据
        PayRefundRespDTO notify = payClient.parseRefundNotify(params, body);
        refundService.notifyRefund(channelId, notify);
        return "success";
    }

    @GetMapping("/get-detail")
    @Operation(summary = "获得回调通知的明细")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pay:notify:query')")
    public CommonResult<PayNotifyTaskDetailRespVO> getNotifyTaskDetail(@RequestParam("id") Long id) {
        PayNotifyTaskDO task = notifyService.getNotifyTask(id);
        if (task == null) {
            return success(null);
        }
        // 拼接返回
        PayAppDO app = appService.getApp(task.getAppId());
        List<PayNotifyLogDO> logs = notifyService.getNotifyLogList(id);
        return success(PayNotifyTaskConvert.INSTANCE.convert(task, app, logs));
    }

    @GetMapping("/page")
    @Operation(summary = "获得回调通知分页")
    @PreAuthorize("@ss.hasPermission('pay:notify:query')")
    public CommonResult<PageResult<PayNotifyTaskRespVO>> getNotifyTaskPage(@Valid PayNotifyTaskPageReqVO pageVO) {
        PageResult<PayNotifyTaskDO> pageResult = notifyService.getNotifyTaskPage(pageVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }
        // 拼接返回
        Map<Long, PayAppDO> appMap = appService.getAppMap(convertList(pageResult.getList(), PayNotifyTaskDO::getAppId));
        return success(PayNotifyTaskConvert.INSTANCE.convertPage(pageResult, appMap));
    }

}
