package top.howie.htron.module.system.api.errorcode.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 错误码的 Response DTO
 *
 * @author Howietron
 */
@Data
public class ErrorCodeRespDTO {

    /**
     * 错误码编码
     */
    private Integer code;
    /**
     * 错误码错误提示
     */
    private String message;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
