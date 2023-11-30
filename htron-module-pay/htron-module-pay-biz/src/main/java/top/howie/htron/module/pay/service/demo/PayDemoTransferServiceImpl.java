package top.howie.htron.module.pay.service.demo;

import top.howie.htron.framework.common.pojo.PageParam;
import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import top.howie.htron.module.pay.convert.demo.PayDemoTransferConvert;
import top.howie.htron.module.pay.dal.dataobject.demo.PayDemoTransferDO;
import top.howie.htron.module.pay.dal.mysql.demo.PayDemoTransferMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.Validator;

import static top.howie.htron.module.pay.enums.transfer.PayTransferStatusEnum.WAITING;

/**
 * 示例转账业务 Service 实现类
 *
 * @author jason
 */
@Service
@Validated
public class PayDemoTransferServiceImpl implements PayDemoTransferService {

    /**
     * 接入的实力应用编号

     * 从 [支付管理 -> 应用信息] 里添加
     */
    private static final Long TRANSFER_APP_ID = 8L;
    @Resource
    private PayDemoTransferMapper demoTransferMapper;
    @Resource
    private Validator validator;

    @Override
    public Long createDemoTransfer(@Valid PayDemoTransferCreateReqVO vo) {
        // 1 校验参数
        vo.validate(validator);
        // 2 保存示例转账业务表
        PayDemoTransferDO demoTransfer = PayDemoTransferConvert.INSTANCE.convert(vo)
                .setAppId(TRANSFER_APP_ID).setTransferStatus(WAITING.getStatus());
        demoTransferMapper.insert(demoTransfer);
        return demoTransfer.getId();
    }

    @Override
    public PageResult<PayDemoTransferDO> getDemoTransferPage(PageParam pageVO) {
        return demoTransferMapper.selectPage(pageVO);
    }
}
