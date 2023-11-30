package top.howie.htron.module.infra.convert.file;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.infra.controller.admin.file.vo.file.FileRespVO;
import top.howie.htron.module.infra.dal.dataobject.file.FileDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
