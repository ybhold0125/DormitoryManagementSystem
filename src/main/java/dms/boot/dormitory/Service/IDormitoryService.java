package dms.boot.dormitory.Service;

import dms.boot.dormitory.domain.Dormitory;

import java.util.Map;

public interface IDormitoryService {
    Map<String, Object> saveDormitoryList(Dormitory dormitory);
    /**
     *  查询宿舍信息
     * @return  宿舍信息
     */
    Map<String, Object> queryDormitoryList(String pageNo, String pageSize);

    /**
     * 批量删除宿舍信息
     * @param ids id集合
     * @return  成功记录 失败返回-1
     */
    Map<String, Object> bitchDeleteDormitory(String[] ids);

    Map<String, Object> updateDormitory(Dormitory dormitory);
}
