package top.howie.htron.module.infra.dal.mysql.db;

import top.howie.htron.framework.mybatis.core.mapper.BaseMapperX;
import top.howie.htron.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author Howietron
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
