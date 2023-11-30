package top.howie.htron.module.system.convert.tenant;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.controller.admin.tenant.vo.tenant.TenantCreateReqVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.tenant.TenantExcelVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.tenant.TenantRespVO;
import top.howie.htron.module.system.controller.admin.tenant.vo.tenant.TenantUpdateReqVO;
import top.howie.htron.module.system.controller.admin.user.vo.user.UserCreateReqVO;
import top.howie.htron.module.system.dal.dataobject.tenant.TenantDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户 Convert
 *
 * @author Howietron
 */
@Mapper
public interface TenantConvert {

    TenantConvert INSTANCE = Mappers.getMapper(TenantConvert.class);

    TenantDO convert(TenantCreateReqVO bean);

    TenantDO convert(TenantUpdateReqVO bean);

    TenantRespVO convert(TenantDO bean);

    List<TenantRespVO> convertList(List<TenantDO> list);

    PageResult<TenantRespVO> convertPage(PageResult<TenantDO> page);

    List<TenantExcelVO> convertList02(List<TenantDO> list);

    default UserCreateReqVO convert02(TenantCreateReqVO bean) {
        UserCreateReqVO reqVO = new UserCreateReqVO();
        reqVO.setUsername(bean.getUsername());
        reqVO.setPassword(bean.getPassword());
        reqVO.setNickname(bean.getContactName()).setMobile(bean.getContactMobile());
        return reqVO;
    }

}
