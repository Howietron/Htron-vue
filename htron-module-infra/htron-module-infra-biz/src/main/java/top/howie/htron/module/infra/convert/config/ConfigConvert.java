package top.howie.htron.module.infra.convert.config;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.infra.controller.admin.config.vo.ConfigCreateReqVO;
import top.howie.htron.module.infra.controller.admin.config.vo.ConfigExcelVO;
import top.howie.htron.module.infra.controller.admin.config.vo.ConfigRespVO;
import top.howie.htron.module.infra.controller.admin.config.vo.ConfigUpdateReqVO;
import top.howie.htron.module.infra.dal.dataobject.config.ConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ConfigConvert {

    ConfigConvert INSTANCE = Mappers.getMapper(ConfigConvert.class);

    PageResult<ConfigRespVO> convertPage(PageResult<ConfigDO> page);

    @Mapping(source = "configKey", target = "key")
    ConfigRespVO convert(ConfigDO bean);

    @Mapping(source = "key", target = "configKey")
    ConfigDO convert(ConfigCreateReqVO bean);

    ConfigDO convert(ConfigUpdateReqVO bean);

    @Mapping(source = "configKey", target = "key")
    List<ConfigExcelVO> convertList(List<ConfigDO> list);

}
