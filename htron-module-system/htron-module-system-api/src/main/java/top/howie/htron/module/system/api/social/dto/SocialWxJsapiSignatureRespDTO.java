package top.howie.htron.module.system.api.social.dto;

import lombok.Data;

/**
 * 微信公众号 JSAPI 签名 Response DTO
 *
 * @author Howietron
 */
@Data
public class SocialWxJsapiSignatureRespDTO {

    /**
     * 微信公众号的 appId
     */
    private String appId;
    /**
     * 匿名串
     */
    private String nonceStr;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * URL
     */
    private String url;
    /**
     * 签名
     */
    private String signature;

}
