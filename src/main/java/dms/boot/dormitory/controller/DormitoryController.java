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
    @PostMapping("/addDormitory")
    public Map<String, Object> addDormitory(Dormitory dormitory){
        return  null;
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
    @PostMapping("/updateDormitory")
    public Map<String, Object> updateDormitoryInfo(Dormitory dormitory){
        return  null;
    }
}
