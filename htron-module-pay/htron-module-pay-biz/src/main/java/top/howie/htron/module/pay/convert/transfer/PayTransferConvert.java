package top.howie.htron.module.pay.convert.transfer;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.framework.pay.core.client.dto.transfer.PayTransferUnifiedReqDTO;
import top.howie.htron.module.pay.api.transfer.dto.PayTransferCreateReqDTO;
import top.howie.htron.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import top.howie.htron.module.pay.controller.admin.transfer.vo.PayTransferCreateReqVO;
import top.howie.htron.module.pay.controller.admin.transfer.vo.PayTransferPageItemRespVO;
import top.howie.htron.module.pay.controller.admin.transfer.vo.PayTransferRespVO;
import top.howie.htron.module.pay.dal.dataobject.transfer.PayTransferDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayTransferConvert {

    PayTransferConvert INSTANCE = Mappers.getMapper(PayTransferConvert.class);

    PayTransferDO convert(PayTransferCreateReqDTO dto);

    PayTransferUnifiedReqDTO convert2(PayTransferCreateReqDTO dto);

    PayTransferCreateReqDTO convert(PayTransferCreateReqVO vo);

    PayTransferCreateReqDTO convert(PayDemoTransferCreateReqVO vo);

    PayTransferRespVO  convert(PayTransferDO bean);

    PageResult<PayTransferPageItemRespVO> convertPage(PageResult<PayTransferDO> pageResult);
}
