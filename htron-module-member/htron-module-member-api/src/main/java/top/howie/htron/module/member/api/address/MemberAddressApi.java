package top.howie.htron.module.member.api.address;

import top.howie.htron.module.member.api.address.dto.MemberAddressRespDTO;

/**
 * 用户收件地址 API 接口
 *
 * @author Howietron
 */
public interface MemberAddressApi {

    /**
     * 获得用户收件地址
     *
     * @param id 收件地址编号
     * @param userId 用户编号
     * @return 用户收件地址
     */
    MemberAddressRespDTO getAddress(Long id, Long userId);

    /**
     * 获得用户默认收件地址
     *
     * @param userId 用户编号
     * @return 用户收件地址
     */
    MemberAddressRespDTO getDefaultAddress(Long userId);

}
