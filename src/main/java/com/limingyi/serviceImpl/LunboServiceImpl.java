package com.limingyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.LunboMapper;
import com.limingyi.entity.Lunbo;
import com.limingyi.service.LunboService;

@Service
public class LunboServiceImpl implements LunboService {
	@Autowired  LunboMapper lunboDao;
	@Override
	public List<Lunbo> getAllLunbo() {
		// TODO Auto-generated method stub
		return lunboDao.getAllLunbo();
	}
	@Override
	public boolean updatelunbo(Lunbo lunbo) {
		// TODO Auto-generated method stub
		return lunboDao.updateLunbo(lunbo);
	}

}
