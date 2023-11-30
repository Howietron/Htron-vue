package top.howie.htron.module.system.convert.dict;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.api.dict.dto.DictDataRespDTO;
import top.howie.htron.module.system.controller.admin.dict.vo.data.*;
import top.howie.htron.module.system.controller.app.dict.vo.AppDictDataRespVO;
import top.howie.htron.module.system.dal.dataobject.dict.DictDataDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DictDataConvert {

    DictDataConvert INSTANCE = Mappers.getMapper(DictDataConvert.class);

    List<DictDataSimpleRespVO> convertList(List<DictDataDO> list);

    DictDataRespVO convert(DictDataDO bean);

    PageResult<DictDataRespVO> convertPage(PageResult<DictDataDO> page);

    DictDataDO convert(DictDataUpdateReqVO bean);

    DictDataDO convert(DictDataCreateReqVO bean);

    List<DictDataExcelVO> convertList02(List<DictDataDO> bean);

    DictDataRespDTO convert02(DictDataDO bean);

    List<AppDictDataRespVO> convertList03(List<DictDataDO> list);

}
