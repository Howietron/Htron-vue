package top.howie.htron.module.member.controller.app.level;

import top.howie.htron.framework.common.pojo.CommonResult;
import top.howie.htron.framework.common.pojo.PageParam;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.framework.security.core.annotations.PreAuthenticated;
import top.howie.htron.module.member.controller.app.level.vo.experience.AppMemberExperienceRecordRespVO;
import top.howie.htron.module.member.convert.level.MemberExperienceRecordConvert;
import top.howie.htron.module.member.dal.dataobject.level.MemberExperienceRecordDO;
import top.howie.htron.module.member.service.level.MemberExperienceRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static top.howie.htron.framework.common.pojo.CommonResult.success;
import static top.howie.htron.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "用户 App - 会员经验记录")
@RestController
@RequestMapping("/member/experience-record")
@Validated
public class AppMemberExperienceRecordController {

    @Resource
    private MemberExperienceRecordService experienceLogService;

    @GetMapping("/page")
    @Operation(summary = "获得会员经验记录分页")
    @PreAuthenticated
    public CommonResult<PageResult<AppMemberExperienceRecordRespVO>> getExperienceRecordPage(
            @Valid PageParam pageParam) {
        PageResult<MemberExperienceRecordDO> pageResult = experienceLogService.getExperienceRecordPage(
                getLoginUserId(), pageParam);
        return success(MemberExperienceRecordConvert.INSTANCE.convertPage02(pageResult));
    }

}
