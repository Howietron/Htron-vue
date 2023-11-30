package top.howie.htron.module.pay.convert.channel;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.pay.controller.admin.channel.vo.PayChannelCreateReqVO;
import top.howie.htron.module.pay.controller.admin.channel.vo.PayChannelRespVO;
import top.howie.htron.module.pay.controller.admin.channel.vo.PayChannelUpdateReqVO;
import top.howie.htron.module.pay.dal.dataobject.channel.PayChannelDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayChannelConvert {

    PayChannelConvert INSTANCE = Mappers.getMapper(PayChannelConvert.class);

    @Mapping(target = "config",ignore = true)
    PayChannelDO convert(PayChannelCreateReqVO bean);

    @Mapping(target = "config",ignore = true)
    PayChannelDO convert(PayChannelUpdateReqVO bean);

    @Mapping(target = "config",expression = "java(top.howie.htron.framework.common.util.json.JsonUtils.toJsonString(bean.getConfig()))")
    PayChannelRespVO convert(PayChannelDO bean);

    PageResult<PayChannelRespVO> convertPage(PageResult<PayChannelDO> page);

}
