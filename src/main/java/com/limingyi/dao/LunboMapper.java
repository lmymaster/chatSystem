package com.limingyi.dao;

import java.util.List;

import com.limingyi.entity.Lunbo;

public interface LunboMapper {

	List<Lunbo> getAllLunbo();

	boolean updateLunbo(Lunbo lunbo);

}
