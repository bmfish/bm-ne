package com.example.bmne.service;

import com.example.bmne.dao.bean.WkContentLog;
import com.example.bmne.dao.mapper.WkContentLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
public class WkContentLogServiceImpl implements WkContentLogService{

    @Autowired
    WkContentLogMapper wkContentLogMapper;

    @Override
    public List<WkContentLog> findWkLogLits() {
        return wkContentLogMapper.selectAll();
    }

    @Override
    public Long saveWkLog() {
       WkContentLog wkContentLog= WkContentLog.builder()
               .content("test"+System.currentTimeMillis())
               .createTime(new Date()).build();
       wkContentLogMapper.insert(wkContentLog);
       return wkContentLog.getId();
    }
}
