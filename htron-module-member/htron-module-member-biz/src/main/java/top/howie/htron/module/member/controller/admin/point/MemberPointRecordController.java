package top.howie.htron.module.member.controller.admin.point;

import top.howie.htron.framework.common.pojo.CommonResult;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.member.controller.admin.point.vo.recrod.MemberPointRecordPageReqVO;
import top.howie.htron.module.member.controller.admin.point.vo.recrod.MemberPointRecordRespVO;
import top.howie.htron.module.member.convert.point.MemberPointRecordConvert;
import top.howie.htron.module.member.dal.dataobject.point.MemberPointRecordDO;
import top.howie.htron.module.member.dal.dataobject.user.MemberUserDO;
import top.howie.htron.module.member.service.point.MemberPointRecordService;
import top.howie.htron.module.member.service.user.MemberUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static top.howie.htron.framework.common.pojo.CommonResult.success;
import static top.howie.htron.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "管理后台 - 签到记录")
@RestController
@RequestMapping("/member/point/record")
@Validated
public class MemberPointRecordController {

    @Resource
    private MemberPointRecordService pointRecordService;

    @Resource
    private MemberUserService memberUserService;

    @GetMapping("/page")
    @Operation(summary = "获得用户积分记录分页")
    @PreAuthorize("@ss.hasPermission('point:record:query')")
    public CommonResult<PageResult<MemberPointRecordRespVO>> getPointRecordPage(@Valid MemberPointRecordPageReqVO pageVO) {
        // 执行分页查询
        PageResult<MemberPointRecordDO> pageResult = pointRecordService.getPointRecordPage(pageVO);
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return success(PageResult.empty(pageResult.getTotal()));
        }

        // 拼接结果返回
        List<MemberUserDO> users = memberUserService.getUserList(
                convertSet(pageResult.getList(), MemberPointRecordDO::getUserId));
        return success(MemberPointRecordConvert.INSTANCE.convertPage(pageResult, users));
    }

}
