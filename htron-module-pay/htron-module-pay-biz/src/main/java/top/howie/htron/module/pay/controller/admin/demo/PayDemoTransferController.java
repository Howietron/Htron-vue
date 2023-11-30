package top.howie.htron.module.pay.controller.admin.demo;

import top.howie.htron.framework.common.pojo.CommonResult;
import top.howie.htron.framework.common.pojo.PageParam;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import top.howie.htron.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferRespVO;
import top.howie.htron.module.pay.convert.demo.PayDemoTransferConvert;
import top.howie.htron.module.pay.dal.dataobject.demo.PayDemoTransferDO;
import top.howie.htron.module.pay.service.demo.PayDemoTransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static top.howie.htron.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 示例转账单")
@RestController
@RequestMapping("/pay/demo-transfer")
@Validated
public class PayDemoTransferController {
    @Resource
    private PayDemoTransferService demoTransferService;

    @PostMapping("/create")
    @Operation(summary = "创建示例转账订单")
    public CommonResult<Long> createDemoTransfer(@Valid @RequestBody PayDemoTransferCreateReqVO createReqVO) {
        return success(demoTransferService.createDemoTransfer(createReqVO));
    }

    @GetMapping("/page")
    @Operation(summary = "获得示例订单分页")
    public CommonResult<PageResult<PayDemoTransferRespVO>> getDemoTransferPage(@Valid PageParam pageVO) {
        PageResult<PayDemoTransferDO> pageResult = demoTransferService.getDemoTransferPage(pageVO);
        return success(PayDemoTransferConvert.INSTANCE.convertPage(pageResult));
    }
}
