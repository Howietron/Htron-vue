package top.howie.htron.module.pay.api.notify.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 支付单的通知 Request DTO
 *
 * @author Howietron
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayOrderNotifyReqDTO {

    /**
     * 商户订单编号
     */
    @NotEmpty(message = "商户订单号不能为空")
    private String merchantOrderId;

    /**
     * 支付订单编号
     */
    @NotNull(message = "支付订单编号不能为空")
    private Long payOrderId;

}
