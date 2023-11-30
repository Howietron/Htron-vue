package top.howie.htron.module.infra.convert.logger;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import top.howie.htron.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExcelVO;
import top.howie.htron.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogRespVO;
import top.howie.htron.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 访问日志 Convert
 *
 * @author Howietron
 */
@Mapper
public interface ApiAccessLogConvert {

    ApiAccessLogConvert INSTANCE = Mappers.getMapper(ApiAccessLogConvert.class);

    ApiAccessLogRespVO convert(ApiAccessLogDO bean);

    List<ApiAccessLogRespVO> convertList(List<ApiAccessLogDO> list);

    PageResult<ApiAccessLogRespVO> convertPage(PageResult<ApiAccessLogDO> page);

    List<ApiAccessLogExcelVO> convertList02(List<ApiAccessLogDO> list);

    ApiAccessLogDO convert(ApiAccessLogCreateReqDTO bean);

}
