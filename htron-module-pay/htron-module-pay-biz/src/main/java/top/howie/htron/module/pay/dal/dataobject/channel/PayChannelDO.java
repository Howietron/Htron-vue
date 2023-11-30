package top.howie.htron.module.pay.dal.dataobject.channel;

import top.howie.htron.framework.common.enums.CommonStatusEnum;
import top.howie.htron.framework.pay.core.client.PayClientConfig;
import top.howie.htron.framework.pay.core.enums.channel.PayChannelEnum;
import top.howie.htron.framework.tenant.core.db.TenantBaseDO;
import top.howie.htron.module.pay.dal.dataobject.app.PayAppDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.*;

/**
 * 支付渠道 DO
 * 一个应用下，会有多种支付渠道，例如说微信支付、支付宝支付等等
 *
 * 即 PayAppDO : PayChannelDO = 1 : n
 *
 * @author Howietron
 */
@TableName(value = "pay_channel", autoResultMap = true)
@KeySequence("pay_channel_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayChannelDO extends TenantBaseDO {

    /**
     * 渠道编号，数据库自增
     */
    private Long id;
    /**
     * 渠道编码
     *
     * 枚举 {@link PayChannelEnum}
     */
    private String code;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;
    /**
     * 渠道费率，单位：百分比
     */
    private Double feeRate;
    /**
     * 备注
     */
    private String remark;

    /**
     * 应用编号
     *
     * 关联 {@link PayAppDO#getId()}
     */
    private Long appId;
    /**
     * 支付渠道配置
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private PayClientConfig config;

}
