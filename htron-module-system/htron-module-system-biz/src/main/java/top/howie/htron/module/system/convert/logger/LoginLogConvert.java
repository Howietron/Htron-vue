package top.howie.htron.module.system.convert.logger;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.api.logger.dto.LoginLogCreateReqDTO;
import top.howie.htron.module.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import top.howie.htron.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import top.howie.htron.module.system.dal.dataobject.logger.LoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    PageResult<LoginLogRespVO> convertPage(PageResult<LoginLogDO> page);

    List<LoginLogExcelVO> convertList(List<LoginLogDO> list);

    LoginLogDO convert(LoginLogCreateReqDTO bean);

}
