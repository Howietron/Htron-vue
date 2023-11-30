package top.howie.htron.module.system.convert.sms;

import top.howie.htron.module.system.controller.admin.sms.vo.log.SmsLogExcelVO;
import top.howie.htron.module.system.controller.admin.sms.vo.log.SmsLogRespVO;
import top.howie.htron.module.system.dal.dataobject.sms.SmsLogDO;
import top.howie.htron.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信日志 Convert
 *
 * @author Howietron
 */
@Mapper
public interface SmsLogConvert {

    SmsLogConvert INSTANCE = Mappers.getMapper(SmsLogConvert.class);

    SmsLogRespVO convert(SmsLogDO bean);

    List<SmsLogRespVO> convertList(List<SmsLogDO> list);

    PageResult<SmsLogRespVO> convertPage(PageResult<SmsLogDO> page);

    List<SmsLogExcelVO> convertList02(List<SmsLogDO> list);

}
