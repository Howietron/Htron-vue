package top.howie.htron.module.system.convert.tenant;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.controller.admin.permission.vo.role.RoleSimpleRespVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.packages.TenantPackageCreateReqVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.packages.TenantPackageRespVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.packages.TenantPackageSimpleRespVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.packages.TenantPackageUpdateReqVO;
import top.howie.htron.module.system.dal.dataobject.tenant.TenantPackageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户套餐 Convert
 *
 * @author Howietron
 */
@Mapper
public interface TenantPackageConvert {

    TenantPackageConvert INSTANCE = Mappers.getMapper(TenantPackageConvert.class);

    TenantPackageDO convert(TenantPackageCreateReqVO bean);

    TenantPackageDO convert(TenantPackageUpdateReqVO bean);

    TenantPackageRespVO convert(TenantPackageDO bean);

    List<TenantPackageRespVO> convertList(List<TenantPackageDO> list);

    PageResult<TenantPackageRespVO> convertPage(PageResult<TenantPackageDO> page);

    List<TenantPackageSimpleRespVO> convertList02(List<TenantPackageDO> list);

}
