package com.limingyi.dao;

import org.apache.ibatis.annotations.Param;

import com.limingyi.entity.UpDown;



public interface UpDownMapper {
	
    int deleteByPrimaryKey(Integer id);
    
    UpDown findNiceDetail( @Param("uid") Integer uid, @Param("tid") Integer tid);
    
    int insertSelective(UpDown record);
}
