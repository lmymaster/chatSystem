package com.limingyi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.UpDownMapper;
import com.limingyi.entity.UpDown;
import com.limingyi.service.UpDownService;



@Service
public class UpDownServiceImpl implements UpDownService {

    @Autowired
    private UpDownMapper updownDao;
 
 
    @Override
    public Integer insertNiceDetail(UpDown niceDetail) {
        System.out.println("impl:"+niceDetail.toString());
        return updownDao.insertSelective(niceDetail);
    }
 
    @Override
    public Integer deleteNiceDetail(Integer id) {
        return updownDao.deleteByPrimaryKey(id);
    }
 

   @Override
    public UpDown findNiceDetail(Integer uid,Integer tid) {
        return updownDao.findNiceDetail(uid,tid);
    }


}