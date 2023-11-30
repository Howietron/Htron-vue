package top.howie.htron.module.member.convert.level;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.member.controller.admin.level.vo.experience.MemberExperienceRecordRespVO;
import top.howie.htron.module.member.controller.app.level.vo.experience.AppMemberExperienceRecordRespVO;
import top.howie.htron.module.member.dal.dataobject.level.MemberExperienceRecordDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 会员经验记录 Convert
 *
 * @author owen
 */
@Mapper
public interface MemberExperienceRecordConvert {

    MemberExperienceRecordConvert INSTANCE = Mappers.getMapper(MemberExperienceRecordConvert.class);

    MemberExperienceRecordRespVO convert(MemberExperienceRecordDO bean);

    List<MemberExperienceRecordRespVO> convertList(List<MemberExperienceRecordDO> list);

    PageResult<MemberExperienceRecordRespVO> convertPage(PageResult<MemberExperienceRecordDO> page);

    MemberExperienceRecordDO convert(Long userId, Integer experience, Integer totalExperience,
                                     String bizId, Integer bizType,
                                     String title, String description);

    PageResult<AppMemberExperienceRecordRespVO> convertPage02(PageResult<MemberExperienceRecordDO> page);

}
