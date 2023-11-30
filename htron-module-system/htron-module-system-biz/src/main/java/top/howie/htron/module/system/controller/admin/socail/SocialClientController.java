package top.howie.htron.module.system.controller.admin.socail;

import top.howie.htron.framework.common.pojo.CommonResult;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientCreateReqVO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientPageReqVO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientRespVO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientUpdateReqVO;
import top.howie.htron.module.system.convert.social.SocialClientConvert;
import top.howie.htron.module.system.dal.dataobject.social.SocialClientDO;
import top.howie.htron.module.system.service.social.SocialClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static top.howie.htron.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 社交客户端")
@RestController
@RequestMapping("/system/social-client")
@Validated
public class SocialClientController {

    @Resource
    private SocialClientService socialClientService;

    @PostMapping("/create")
    @Operation(summary = "创建社交客户端")
    @PreAuthorize("@ss.hasPermission('system:social-client:create')")
    public CommonResult<Long> createSocialClient(@Valid @RequestBody SocialClientCreateReqVO createReqVO) {
        return success(socialClientService.createSocialClient(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新社交客户端")
    @PreAuthorize("@ss.hasPermission('system:social-client:update')")
    public CommonResult<Boolean> updateSocialClient(@Valid @RequestBody SocialClientUpdateReqVO updateReqVO) {
        socialClientService.updateSocialClient(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除社交客户端")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:social-client:delete')")
    public CommonResult<Boolean> deleteSocialClient(@RequestParam("id") Long id) {
        socialClientService.deleteSocialClient(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得社交客户端")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:social-client:query')")
    public CommonResult<SocialClientRespVO> getSocialClient(@RequestParam("id") Long id) {
        SocialClientDO socialClient = socialClientService.getSocialClient(id);
        return success(SocialClientConvert.INSTANCE.convert(socialClient));
    }

    @GetMapping("/page")
    @Operation(summary = "获得社交客户端分页")
    @PreAuthorize("@ss.hasPermission('system:social-client:query')")
    public CommonResult<PageResult<SocialClientRespVO>> getSocialClientPage(@Valid SocialClientPageReqVO pageVO) {
        PageResult<SocialClientDO> pageResult = socialClientService.getSocialClientPage(pageVO);
        return success(SocialClientConvert.INSTANCE.convertPage(pageResult));
    }

}
