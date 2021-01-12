package dms.boot.dormitory.Service.impl;

import dms.boot.dormitory.Service.IDormitoryService;
import dms.boot.dormitory.dao.dormitoryDao.IDormitoryDao;
import dms.boot.dormitory.domain.Dormitory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DormitoryServiceImpl implements IDormitoryService {
    private final IDormitoryDao iDormitoryDao;

    public DormitoryServiceImpl(IDormitoryDao iDormitoryDao) {
        this.iDormitoryDao = iDormitoryDao;
    }

    @Override
    public Map<String, Object> saveDormitoryList(Dormitory dormitory) {
        Map<String, Object> map = new HashMap<>();
        int i = iDormitoryDao.saveDormitory(dormitory);
        if (i > 0) {
            map.put("status", "true");
            map.put("msg", "执行成功");
        } else {
            map.put("status", "false");
            map.put("msg", "执行失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> queryDormitoryList(String pageNo, String pageSize) {
        Map<String, Object> map = new HashMap<>();
        int currentPage = 1;
        int paSize = 10;
        if (StringUtils.isNotBlank(pageNo)) {
            currentPage = Integer.parseInt(pageNo);
        }
        if (StringUtils.isNotBlank(pageSize)) {
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

    @Override
    public Map<String, Object> bitchDeleteDormitory(String[] ids) {
        Map<String, Object> map = new HashMap<>();
        int i = iDormitoryDao.bitchDeleteDormitory(ids);
        if (i > 0) {
            map.put("status", "true");
            map.put("msg", "执行成功");
        } else {
            map.put("status", "false");
            map.put("msg", "执行失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> updateDormitory(Dormitory dormitory) {
        Map<String, Object> map = new HashMap<>();
        int i = iDormitoryDao.updateDormitory(dormitory);
        if (i > 0) {
            map.put("status", "true");
            map.put("msg", "执行成功");
        } else {
            map.put("status", "false");
            map.put("msg", "执行失败");
        }
        return map;
    }
}
