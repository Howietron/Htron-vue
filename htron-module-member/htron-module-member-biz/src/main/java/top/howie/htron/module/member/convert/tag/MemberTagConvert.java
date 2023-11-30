package top.howie.htron.module.member.convert.tag;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.member.controller.admin.tag.vo.MemberTagCreateReqVO;
import top.howie.htron.module.member.controller.admin.tag.vo.MemberTagRespVO;
import top.howie.htron.module.member.controller.admin.tag.vo.MemberTagUpdateReqVO;
import top.howie.htron.module.member.dal.dataobject.tag.MemberTagDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 会员标签 Convert
 *
 * @author Howietron
 */
@Mapper
public interface MemberTagConvert {

    MemberTagConvert INSTANCE = Mappers.getMapper(MemberTagConvert.class);

    MemberTagDO convert(MemberTagCreateReqVO bean);

    MemberTagDO convert(MemberTagUpdateReqVO bean);

    MemberTagRespVO convert(MemberTagDO bean);

    List<MemberTagRespVO> convertList(List<MemberTagDO> list);

    PageResult<MemberTagRespVO> convertPage(PageResult<MemberTagDO> page);

}
