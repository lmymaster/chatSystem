package com.limingyi.dao;

import com.limingyi.entity.LoginLog;

public interface LoginLogMapper {
	 int deleteByPrimaryKey(Long id);

	    int insert(LoginLog record);

	    int insertSelective(LoginLog record);

	    LoginLog selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(LoginLog record);

}