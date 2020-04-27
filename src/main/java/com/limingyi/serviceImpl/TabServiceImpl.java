package com.limingyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.TabMapper;
import com.limingyi.entity.Tab;
import com.limingyi.service.TapService;

@Service
public class TabServiceImpl implements TapService{

    @Autowired
    public TabMapper tabDao;

    public List<Tab> getAllTabs() {
        return tabDao.getAllTabs();
    }

    public Tab getByTabNameEn(String tabNameEn) {
        return tabDao.getByTabNameEn(tabNameEn);
    }
}