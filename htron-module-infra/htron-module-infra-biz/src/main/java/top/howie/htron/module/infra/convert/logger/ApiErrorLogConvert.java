package top.howie.htron.module.infra.convert.logger;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import top.howie.htron.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import top.howie.htron.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import top.howie.htron.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author Howietron
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
