package top.howie.htron.module.pay.api.refund;

import top.howie.htron.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import top.howie.htron.module.pay.api.refund.dto.PayRefundRespDTO;

import javax.validation.Valid;

/**
 * 退款单 API 接口
 *
 * @author Howietron
 */
public interface PayRefundApi {

    /**
     * 创建退款单
     *
     * @param reqDTO 创建请求
     * @return 退款单编号
     */
    Long createRefund(@Valid PayRefundCreateReqDTO reqDTO);

    /**
     * 获得退款单
     *
     * @param id 退款单编号
     * @return 退款单
     */
    PayRefundRespDTO getRefund(Long id);

}
