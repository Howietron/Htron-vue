package top.howie.htron.module.pay.convert.wallet;

import java.util.*;

import top.howie.htron.framework.common.pojo.PageResult;

import top.howie.htron.module.pay.controller.admin.wallet.vo.rechargepackage.WalletRechargePackageCreateReqVO;
import top.howie.htron.module.pay.controller.admin.wallet.vo.rechargepackage.WalletRechargePackageRespVO;
import top.howie.htron.module.pay.controller.admin.wallet.vo.rechargepackage.WalletRechargePackageUpdateReqVO;
import top.howie.htron.module.pay.dal.dataobject.wallet.PayWalletRechargePackageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletRechargePackageConvert {

    WalletRechargePackageConvert INSTANCE = Mappers.getMapper(WalletRechargePackageConvert.class);

    PayWalletRechargePackageDO convert(WalletRechargePackageCreateReqVO bean);

    PayWalletRechargePackageDO convert(WalletRechargePackageUpdateReqVO bean);

    WalletRechargePackageRespVO convert(PayWalletRechargePackageDO bean);

    List<WalletRechargePackageRespVO> convertList(List<PayWalletRechargePackageDO> list);

    PageResult<WalletRechargePackageRespVO> convertPage(PageResult<PayWalletRechargePackageDO> page);

}
