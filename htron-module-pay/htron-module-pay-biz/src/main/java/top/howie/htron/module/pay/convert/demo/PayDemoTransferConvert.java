package top.howie.htron.module.pay.convert.demo;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import top.howie.htron.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferRespVO;
import top.howie.htron.module.pay.dal.dataobject.demo.PayDemoTransferDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jason
 */
@Mapper
public interface PayDemoTransferConvert {

    PayDemoTransferConvert INSTANCE = Mappers.getMapper(PayDemoTransferConvert.class);

    PayDemoTransferDO convert(PayDemoTransferCreateReqVO bean);

    PageResult<PayDemoTransferRespVO> convertPage(PageResult<PayDemoTransferDO> pageResult);
}
