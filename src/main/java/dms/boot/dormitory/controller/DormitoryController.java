package dms.boot.dormitory.controller;

import dms.boot.annotation.JwtToken;
import dms.boot.dormitory.Service.IDormitoryService;
import dms.boot.dormitory.domain.Dormitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("dormitory")
@CrossOrigin
public class DormitoryController {
    @Autowired
    private IDormitoryService iDormitoryService;

    @JwtToken
    @PostMapping("/saveDormitory")
    public Map<String, Object> saveDormitory(@RequestBody Dormitory dormitory){
        return  iDormitoryService.saveDormitory(dormitory);
    }

    @JwtToken
    @PostMapping("/deleteDormitoryInfo")
    public Map<String, Object> deleteDormitoryInfo(String[] ids) {
        return iDormitoryService.bitchDeleteDormitory(ids);
    }

    @JwtToken
    @GetMapping("/queryDormitoryInfoList")
    public Map<String, Object> queryDormitoryInfoList(String pageNo, String pageSize){
        return iDormitoryService.queryDormitoryList(pageNo, pageSize);
    }

    @JwtToken
    @PostMapping("/queryDormitory")
    public Map<String, Object> queryDormitory(int id) {
        return iDormitoryService.queryDormitory(id);
    }

    @JwtToken
    @PostMapping("/updateDormitory")
    public Map<String, Object> updateDormitoryInfo(@RequestBody Dormitory dormitory){
        return  iDormitoryService.updateDormitory(dormitory);
    }
}
