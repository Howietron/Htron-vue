package top.howie.htron.module.infra.convert.test;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import top.howie.htron.module.infra.controller.admin.test.vo.TestDemoExcelVO;
import top.howie.htron.module.infra.controller.admin.test.vo.TestDemoRespVO;
import top.howie.htron.module.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import top.howie.htron.module.infra.dal.dataobject.test.TestDemoDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 字典类型 Convert
 *
 * @author Howietron
 */
@Mapper
public interface TestDemoConvert {

    TestDemoConvert INSTANCE = Mappers.getMapper(TestDemoConvert.class);

    TestDemoDO convert(TestDemoCreateReqVO bean);

    TestDemoDO convert(TestDemoUpdateReqVO bean);

    TestDemoRespVO convert(TestDemoDO bean);

    List<TestDemoRespVO> convertList(List<TestDemoDO> list);

    PageResult<TestDemoRespVO> convertPage(PageResult<TestDemoDO> page);

    List<TestDemoExcelVO> convertList02(List<TestDemoDO> list);

}
