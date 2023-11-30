package top.howie.htron.module.pay.api.refund;

import top.howie.htron.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import top.howie.htron.module.pay.api.refund.dto.PayRefundRespDTO;
import top.howie.htron.module.pay.convert.refund.PayRefundConvert;
import top.howie.htron.module.pay.service.refund.PayRefundService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 退款单 API 实现类
 *
 * @author Howietron
 */
@Service
@Validated
public class PayRefundApiImpl implements PayRefundApi {

    @Resource
    private PayRefundService payRefundService;

    @Override
    public Long createRefund(PayRefundCreateReqDTO reqDTO) {
        return payRefundService.createPayRefund(reqDTO);
    }

    @Override
    public PayRefundRespDTO getRefund(Long id) {
        return PayRefundConvert.INSTANCE.convert02(payRefundService.getRefund(id));
    }

}
