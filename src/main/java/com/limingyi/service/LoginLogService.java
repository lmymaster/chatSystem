package com.limingyi.service;

import com.limingyi.entity.LoginLog;

public interface LoginLogService {

    /**
     * 插入一条登录日志
     */
    boolean addLog(LoginLog log);
}
