package top.howie.htron.module.pay.api.order;

import top.howie.htron.module.pay.api.order.dto.PayOrderCreateReqDTO;
import top.howie.htron.module.pay.api.order.dto.PayOrderRespDTO;
import top.howie.htron.module.pay.convert.order.PayOrderConvert;
import top.howie.htron.module.pay.dal.dataobject.order.PayOrderDO;
import top.howie.htron.module.pay.service.order.PayOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 支付单 API 实现类
 *
 * @author Howietron
 */
@Service
public class PayOrderApiImpl implements PayOrderApi {

    @Resource
    private PayOrderService payOrderService;

    @Override
    public Long createOrder(PayOrderCreateReqDTO reqDTO) {
        return payOrderService.createOrder(reqDTO);
    }

    @Override
    public PayOrderRespDTO getOrder(Long id) {
        PayOrderDO order = payOrderService.getOrder(id);
        return PayOrderConvert.INSTANCE.convert2(order);
    }

    @Override
    public void updatePayOrderPrice(Long id, Integer payPrice) {
        payOrderService.updatePayOrderPrice(id, payPrice);
    }

}
