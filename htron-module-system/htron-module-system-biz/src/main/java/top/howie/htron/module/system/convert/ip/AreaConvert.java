package top.howie.htron.module.system.convert.ip;

import top.howie.htron.framework.ip.core.Area;
import top.howie.htron.module.system.controller.admin.ip.vo.AreaNodeRespVO;
import top.howie.htron.module.system.controller.app.ip.vo.AppAreaNodeRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AreaConvert {

    AreaConvert INSTANCE = Mappers.getMapper(AreaConvert.class);

    List<AreaNodeRespVO> convertList(List<Area> list);

    List<AppAreaNodeRespVO> convertList3(List<Area> list);

}
