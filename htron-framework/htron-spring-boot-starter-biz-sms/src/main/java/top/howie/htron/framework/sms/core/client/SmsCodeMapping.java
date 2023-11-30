package top.howie.htron.framework.sms.core.client;

import top.howie.htron.framework.common.exception.ErrorCode;
import top.howie.htron.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.function.Function;

/**
 * 将 API 的错误码，转换为通用的错误码
 *
 * @see SmsCommonResult
 * @see SmsFrameworkErrorCodeConstants
 *
 * @author Howietron
 */
public interface SmsCodeMapping extends Function<String, ErrorCode> {
}
