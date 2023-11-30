package top.howie.htron.module.member.dal.mysql.config;

import top.howie.htron.framework.mybatis.core.mapper.BaseMapperX;
import top.howie.htron.module.member.dal.dataobject.config.MemberConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分设置 Mapper
 *
 * @author QingX
 */
@Mapper
public interface MemberConfigMapper extends BaseMapperX<MemberConfigDO> {
}
