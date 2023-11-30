package top.howie.htron.module.system.convert.sms;

import top.howie.htron.module.system.controller.admin.sms.vo.channel.SmsChannelCreateReqVO;
import top.howie.htron.module.system.controller.admin.sms.vo.channel.SmsChannelRespVO;
import top.howie.htron.module.system.controller.admin.sms.vo.channel.SmsChannelSimpleRespVO;
import top.howie.htron.module.system.controller.admin.sms.vo.channel.SmsChannelUpdateReqVO;
import top.howie.htron.module.system.dal.dataobject.sms.SmsChannelDO;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.framework.sms.core.property.SmsChannelProperties;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信渠道 Convert
 *
 * @author Howietron
 */
@Mapper
public interface SmsChannelConvert {

    SmsChannelConvert INSTANCE = Mappers.getMapper(SmsChannelConvert.class);

    SmsChannelDO convert(SmsChannelCreateReqVO bean);

    SmsChannelDO convert(SmsChannelUpdateReqVO bean);

    SmsChannelRespVO convert(SmsChannelDO bean);

    List<SmsChannelRespVO> convertList(List<SmsChannelDO> list);

    PageResult<SmsChannelRespVO> convertPage(PageResult<SmsChannelDO> page);

    List<SmsChannelSimpleRespVO> convertList03(List<SmsChannelDO> list);

    SmsChannelProperties convert02(SmsChannelDO channel);

}
