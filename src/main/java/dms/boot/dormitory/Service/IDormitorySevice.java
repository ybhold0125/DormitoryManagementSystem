package dms.boot.dormitory.Service;

import java.util.Map;

public interface IDormitorySevice {
    /**
     *  查询宿舍信息
     * @return  宿舍信息
     */
    Map<String, Object> queryDormitoryList(String pageNo, String pageSize);
}
