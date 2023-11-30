package top.howie.htron.module.pay.convert.wallet;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.pay.controller.admin.wallet.vo.transaction.PayWalletTransactionRespVO;
import top.howie.htron.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import top.howie.htron.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import top.howie.htron.module.pay.service.wallet.bo.WalletTransactionCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<AppPayWalletTransactionRespVO> convertPage(PageResult<PayWalletTransactionDO> page);

    PageResult<PayWalletTransactionRespVO> convertPage2(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(WalletTransactionCreateReqBO bean);

}
