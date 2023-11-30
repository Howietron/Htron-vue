package top.howie.htron.module.pay.convert.demo;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.pay.controller.admin.demo.vo.PayDemoOrderCreateReqVO;
import top.howie.htron.module.pay.controller.admin.demo.vo.PayDemoOrderRespVO;
import top.howie.htron.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 示例订单 Convert
 *
 * @author Howietron
 */
@Mapper
public interface PayDemoOrderConvert {

    PayDemoOrderConvert INSTANCE = Mappers.getMapper(PayDemoOrderConvert.class);

    PayDemoOrderDO convert(PayDemoOrderCreateReqVO bean);

    PayDemoOrderRespVO convert(PayDemoOrderDO bean);

    PageResult<PayDemoOrderRespVO> convertPage(PageResult<PayDemoOrderDO> page);

}
