package top.howie.htron.module.infra.dal.mysql.file;

import top.howie.htron.module.infra.dal.dataobject.file.FileContentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileContentMapper extends BaseMapper<FileContentDO> {
}
