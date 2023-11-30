package top.howie.htron.framework.sms.core.client.impl.debug;

import top.howie.htron.framework.common.exception.ErrorCode;
import top.howie.htron.framework.common.exception.enums.GlobalErrorCodeConstants;
import top.howie.htron.framework.sms.core.client.SmsCodeMapping;
import top.howie.htron.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @author Howietron
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
