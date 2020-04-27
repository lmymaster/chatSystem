package com.limingyi.service;

import java.util.List;

import com.limingyi.entity.Tab;


public interface TapService {
    List<Tab> getAllTabs();

    Tab getByTabNameEn(String tabName);
}
