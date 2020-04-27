package com.limingyi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.LoginLogMapper;
import com.limingyi.entity.LoginLog;
import com.limingyi.service.LoginLogService;



@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    public LoginLogMapper loginLogDao;

    public boolean addLog(LoginLog log) {

        if(loginLogDao.insert(log)>0){
            return true;
        }else {
            return false;
        }
    }
}