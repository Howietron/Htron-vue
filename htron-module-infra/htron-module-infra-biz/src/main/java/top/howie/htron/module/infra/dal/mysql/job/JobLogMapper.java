package top.howie.htron.module.infra.dal.mysql.job;

import top.howie.htron.framework.common.pojo.PageResult;
import top.howie.htron.framework.mybatis.core.mapper.BaseMapperX;
import top.howie.htron.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.howie.htron.module.infra.controller.admin.job.vo.log.JobLogExportReqVO;
import top.howie.htron.module.infra.controller.admin.job.vo.log.JobLogPageReqVO;
import top.howie.htron.module.infra.dal.dataobject.job.JobLogDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 任务日志 Mapper
 *
 * @author Howietron
 */
@Mapper
public interface JobLogMapper extends BaseMapperX<JobLogDO> {

    default PageResult<JobLogDO> selectPage(JobLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JobLogDO>()
                .eqIfPresent(JobLogDO::getJobId, reqVO.getJobId())
                .likeIfPresent(JobLogDO::getHandlerName, reqVO.getHandlerName())
                .geIfPresent(JobLogDO::getBeginTime, reqVO.getBeginTime())
                .leIfPresent(JobLogDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(JobLogDO::getStatus, reqVO.getStatus())
                .orderByDesc(JobLogDO::getId) // ID 倒序
        );
    }

    default List<JobLogDO> selectList(JobLogExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<JobLogDO>()
                .eqIfPresent(JobLogDO::getJobId, reqVO.getJobId())
                .likeIfPresent(JobLogDO::getHandlerName, reqVO.getHandlerName())
                .geIfPresent(JobLogDO::getBeginTime, reqVO.getBeginTime())
                .leIfPresent(JobLogDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(JobLogDO::getStatus, reqVO.getStatus())
                .orderByDesc(JobLogDO::getId) // ID 倒序
        );
    }

    /**
     * 物理删除指定时间之前的日志
     *
     * @param createTime 最大时间
     * @param limit 删除条数，防止一次删除太多
     * @return 删除条数
     */
    @Delete("DELETE FROM infra_job_log WHERE create_time < #{createTime} LIMIT #{limit}")
    Integer deleteByCreateTimeLt(@Param("createTime") LocalDateTime createTime, @Param("limit") Integer limit);

}
