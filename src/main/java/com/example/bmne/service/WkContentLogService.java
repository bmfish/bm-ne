package com.example.bmne.service;

import com.example.bmne.dao.bean.WkContentLog;

import java.util.List;

public interface WkContentLogService {

    List<WkContentLog> findWkLogLits();

    Long saveWkLog();
}
