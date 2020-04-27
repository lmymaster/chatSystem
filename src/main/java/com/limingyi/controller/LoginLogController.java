package com.limingyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.limingyi.serviceImpl.LoginLogServiceImpl;

/**
 * 登录日志控制类
 */
@Controller
public class LoginLogController {

    @Autowired
    public LoginLogServiceImpl loginLogService;


}
