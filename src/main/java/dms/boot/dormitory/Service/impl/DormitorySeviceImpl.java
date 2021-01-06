package dms.boot.dormitory.Service.impl;

import dms.boot.dormitory.Service.IDormitorySevice;
import dms.boot.dormitory.dao.dormitoryDao.IDormitoryDao;
import dms.boot.dormitory.domain.Dormitory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DormitorySeviceImpl implements IDormitorySevice {
    @Autowired
    private IDormitoryDao iDormitoryDao;

    @Override
    public Map<String, Object> queryDormitoryList(String pageNo, String pageSize) {
        Map<String,Object> map = new HashMap<>();
        int currentPage = 1;
        int paSize = 10;
        if(StringUtils.isNotBlank(pageNo)){
            currentPage = Integer.parseInt(pageNo);
        }
        if(StringUtils.isNotBlank(pageSize)){
            paSize = Integer.parseInt(pageSize);
        }
        int leftLimit = (currentPage - 1) * paSize;
        int rightLimit = paSize;
        List<Dormitory> dormitoryInfo = iDormitoryDao.queryDormitoryInfoList(leftLimit, rightLimit);
        int total = iDormitoryDao.queryDormitoryCount();
        map.put("res", dormitoryInfo);
        map.put("total", total);
        return map;
    }
}
