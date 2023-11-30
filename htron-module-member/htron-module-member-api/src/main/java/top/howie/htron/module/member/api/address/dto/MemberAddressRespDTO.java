package top.howie.htron.module.member.api.address.dto;

import lombok.Data;

/**
 * 用户收件地址 Response DTO
 *
 * @author Howietron
 */
@Data
public class MemberAddressRespDTO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 收件人名称
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 地区编号
     */
    private Integer areaId;
    /**
     * 收件详细地址
     */
    private String detailAddress;
    /**
     * 是否默认
     */
    private Boolean defaultStatus;

}
