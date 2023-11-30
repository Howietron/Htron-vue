package top.howie.htron.module.system.service.social;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.framework.test.core.ut.BaseDbUnitTest;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientCreateReqVO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientPageReqVO;
import top.howie.htron.module.system.controller.admin.socail.vo.client.SocialClientUpdateReqVO;
import top.howie.htron.module.system.dal.dataobject.social.SocialClientDO;
import top.howie.htron.module.system.dal.mysql.social.SocialClientMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static top.howie.htron.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static top.howie.htron.framework.test.core.util.AssertUtils.assertPojoEquals;
import static top.howie.htron.framework.test.core.util.AssertUtils.assertServiceException;
import static top.howie.htron.framework.test.core.util.RandomUtils.randomLongId;
import static top.howie.htron.framework.test.core.util.RandomUtils.randomPojo;
import static top.howie.htron.module.system.enums.ErrorCodeConstants.SOCIAL_CLIENT_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;

// TODO Howie：单测后续补充下；
/**
 * {@link SocialClientServiceImpl} 的单元测试类
 *
 * @author Howietron
 */
@Import(SocialClientServiceImpl.class)
@Disabled
public class SocialClientServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SocialClientServiceImpl socialClientService;

    @Resource
    private SocialClientMapper socialClientMapper;

    @Test
    public void testCreateSocialClient_success() {
        // 准备参数
        SocialClientCreateReqVO reqVO = randomPojo(SocialClientCreateReqVO.class);

        // 调用
        Long socialClientId = socialClientService.createSocialClient(reqVO);
        // 断言
        assertNotNull(socialClientId);
        // 校验记录的属性是否正确
        SocialClientDO socialClient = socialClientMapper.selectById(socialClientId);
        assertPojoEquals(reqVO, socialClient);
    }

    @Test
    public void testUpdateSocialClient_success() {
        // mock 数据
        SocialClientDO dbSocialClient = randomPojo(SocialClientDO.class);
        socialClientMapper.insert(dbSocialClient);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SocialClientUpdateReqVO reqVO = randomPojo(SocialClientUpdateReqVO.class, o -> {
            o.setId(dbSocialClient.getId()); // 设置更新的 ID
        });

        // 调用
        socialClientService.updateSocialClient(reqVO);
        // 校验是否更新正确
        SocialClientDO socialClient = socialClientMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, socialClient);
    }

    @Test
    public void testUpdateSocialClient_notExists() {
        // 准备参数
        SocialClientUpdateReqVO reqVO = randomPojo(SocialClientUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> socialClientService.updateSocialClient(reqVO), SOCIAL_CLIENT_NOT_EXISTS);
    }

    @Test
    public void testDeleteSocialClient_success() {
        // mock 数据
        SocialClientDO dbSocialClient = randomPojo(SocialClientDO.class);
        socialClientMapper.insert(dbSocialClient);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSocialClient.getId();

        // 调用
        socialClientService.deleteSocialClient(id);
        // 校验数据不存在了
        assertNull(socialClientMapper.selectById(id));
    }

    @Test
    public void testDeleteSocialClient_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> socialClientService.deleteSocialClient(id), SOCIAL_CLIENT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSocialClientPage() {
        // mock 数据
        SocialClientDO dbSocialClient = randomPojo(SocialClientDO.class, o -> { // 等会查询到
            o.setName(null);
            o.setSocialType(null);
            o.setUserType(null);
            o.setClientId(null);
            o.setClientSecret(null);
            o.setStatus(null);
            o.setCreateTime(null);
        });
        socialClientMapper.insert(dbSocialClient);
        // 测试 name 不匹配
        socialClientMapper.insert(cloneIgnoreId(dbSocialClient, o -> o.setName(null)));
        // 测试 socialType 不匹配
        socialClientMapper.insert(cloneIgnoreId(dbSocialClient, o -> o.setSocialType(null)));
        // 测试 userType 不匹配
        socialClientMapper.insert(cloneIgnoreId(dbSocialClient, o -> o.setUserType(null)));
        // 测试 clientId 不匹配
        socialClientMapper.insert(cloneIgnoreId(dbSocialClient, o -> o.setClientId(null)));
        // 测试 clientSecret 不匹配
        socialClientMapper.insert(cloneIgnoreId(dbSocialClient, o -> o.setClientSecret(null)));
        // 测试 status 不匹配
        socialClientMapper.insert(cloneIgnoreId(dbSocialClient, o -> o.setStatus(null)));
        // 测试 createTime 不匹配
        socialClientMapper.insert(cloneIgnoreId(dbSocialClient, o -> o.setCreateTime(null)));
        // 准备参数
        SocialClientPageReqVO reqVO = new SocialClientPageReqVO();
        reqVO.setName(null);
        reqVO.setSocialType(null);
        reqVO.setUserType(null);
        reqVO.setClientId(null);
        reqVO.setStatus(null);

        // 调用
        PageResult<SocialClientDO> pageResult = socialClientService.getSocialClientPage(reqVO);
        // 断言
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(dbSocialClient, pageResult.getList().get(0));
    }

}
