package top.howie.htron.module.system.convert.social;

import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.api.social.dto.SocialWxJsapiSignatureRespDTO;
import top.howie.htron.module.system.api.social.dto.SocialWxPhoneNumberInfoRespDTO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientCreateReqVO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientRespVO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientUpdateReqVO;
import top.howie.htron.module.system.dal.dataobject.social.SocialClientDO;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SocialClientConvert {

    SocialClientConvert INSTANCE = Mappers.getMapper(SocialClientConvert.class);

    SocialWxJsapiSignatureRespDTO convert(WxJsapiSignature bean);

    SocialWxPhoneNumberInfoRespDTO convert(WxMaPhoneNumberInfo bean);

    SocialClientDO convert(SocialClientCreateReqVO bean);

    SocialClientDO convert(SocialClientUpdateReqVO bean);

    SocialClientRespVO convert(SocialClientDO bean);

    List<SocialClientRespVO> convertList(List<SocialClientDO> list);

    PageResult<SocialClientRespVO> convertPage(PageResult<SocialClientDO> page);



}
