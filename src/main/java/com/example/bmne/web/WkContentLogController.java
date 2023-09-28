package com.example.bmne.web;


import com.example.bmne.dao.bean.WkContentLog;
import com.example.bmne.service.WkContentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/wkcontent")
public class WkContentLogController {

    @Autowired
    WkContentLogService wkContentLogService;

    @GetMapping("/list")
    public List<WkContentLog> selectAll(){

        return wkContentLogService.findWkLogLits();
    }


    @GetMapping("/add")
    public Long addlog(){
        return wkContentLogService.saveWkLog();
    }
}
