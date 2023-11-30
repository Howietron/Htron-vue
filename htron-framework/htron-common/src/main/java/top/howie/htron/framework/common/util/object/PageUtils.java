package top.howie.htron.framework.common.util.object;

import top.howie.htron.framework.common.pojo.PageParam;

/**
 * {@link top.howie.htron.framework.common.pojo.PageParam} 工具类
 *
 * @author Howietron
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
