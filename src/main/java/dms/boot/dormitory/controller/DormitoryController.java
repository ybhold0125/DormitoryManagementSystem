package dms.boot.dormitory.controller;

import dms.boot.annotation.JwtToken;
import dms.boot.dormitory.Service.IDormitorySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("dormitory")
@CrossOrigin
public class DormitoryController {
    @Autowired
    private IDormitorySevice iDormitorySevice;

    @JwtToken
    @GetMapping("/queryDormitoryInfoList")
    public Map<String, Object> queryDormitoryInfoList(String pageNo, String pageSize){
        return iDormitorySevice.queryDormitoryList(pageNo, pageSize);
    }
}
