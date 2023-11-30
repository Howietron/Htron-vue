package top.howie.htron.module.pay.service.transfer;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.pay.api.transfer.dto.PayTransferCreateReqDTO;
import top.howie.htron.module.pay.controller.admin.transfer.vo.PayTransferCreateReqVO;
import top.howie.htron.module.pay.controller.admin.transfer.vo.PayTransferPageReqVO;
import top.howie.htron.module.pay.dal.dataobject.transfer.PayTransferDO;

import javax.validation.Valid;

/**
 * 转账 Service 接口
 *
 * @author jason
 */
public interface PayTransferService {

    /**
     * 创建转账单，并发起转账
     *
     * 此时，会发起转账渠道的调用
     *
     * @param reqVO 请求
     * @param userIp 用户 ip
     * @return 渠道的返回结果
     */
    PayTransferDO createTransfer(@Valid PayTransferCreateReqVO reqVO, String userIp);

    /**
     * 创建转账单，并发起转账
     *
     * @param reqDTO 创建请求
     * @return 转账单编号
     */
    Long createTransfer(@Valid PayTransferCreateReqDTO reqDTO);

    /**
     * 获取转账单
     * @param id 转账单编号
     */
    PayTransferDO getTransfer(Long id);

    /**
     * 获得转账单分页
     *
     * @param pageReqVO 分页查询
     * @return 转账单分页
     */
    PageResult<PayTransferDO> getTransferPage(PayTransferPageReqVO pageReqVO);

}
