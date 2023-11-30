package top.howie.htron.module.system.service.logger;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.module.system.api.logger.dto.OperateLogCreateReqDTO;
import top.howie.htron.module.system.controller.admin.logger.vo.operatelog.OperateLogExportReqVO;
import top.howie.htron.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import top.howie.htron.module.system.dal.dataobject.logger.OperateLogDO;

import java.util.List;

/**
 * 操作日志 Service 接口
 *
 * @author Howietron
 */
public interface OperateLogService {

    /**
     * 记录操作日志
     *
     * @param createReqDTO 操作日志请求
     */
    void createOperateLog(OperateLogCreateReqDTO createReqDTO);

    /**
     * 获得操作日志分页列表
     *
     * @param reqVO 分页条件
     * @return 操作日志分页列表
     */
    PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqVO reqVO);

    /**
     * 获得操作日志列表
     *
     * @param reqVO 列表条件
     * @return 日志列表
     */
    List<OperateLogDO> getOperateLogList(OperateLogExportReqVO reqVO);

}
