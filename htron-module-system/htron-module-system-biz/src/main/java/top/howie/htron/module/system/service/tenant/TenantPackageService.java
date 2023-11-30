package top.howie.htron.module.system.service.tenant;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.controller.admin.tenant.vo.packages.TenantPackageCreateReqVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.packages.TenantPackagePageReqVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.packages.TenantPackageUpdateReqVO;
import top.howie.htron.module.system.dal.dataobject.tenant.TenantPackageDO;

import javax.validation.Valid;
import java.util.List;

/**
 * 租户套餐 Service 接口
 *
 * @author Howietron
 */
public interface TenantPackageService {

    /**
     * 创建租户套餐
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTenantPackage(@Valid TenantPackageCreateReqVO createReqVO);

    /**
     * 更新租户套餐
     *
     * @param updateReqVO 更新信息
     */
    void updateTenantPackage(@Valid TenantPackageUpdateReqVO updateReqVO);

    /**
     * 删除租户套餐
     *
     * @param id 编号
     */
    void deleteTenantPackage(Long id);

    /**
     * 获得租户套餐
     *
     * @param id 编号
     * @return 租户套餐
     */
    TenantPackageDO getTenantPackage(Long id);

    /**
     * 获得租户套餐分页
     *
     * @param pageReqVO 分页查询
     * @return 租户套餐分页
     */
    PageResult<TenantPackageDO> getTenantPackagePage(TenantPackagePageReqVO pageReqVO);

    /**
     * 校验租户套餐
     *
     * @param id 编号
     * @return 租户套餐
     */
    TenantPackageDO validTenantPackage(Long id);

    /**
     * 获得指定状态的租户套餐列表
     *
     * @param status 状态
     * @return 租户套餐
     */
    List<TenantPackageDO> getTenantPackageListByStatus(Integer status);

}
