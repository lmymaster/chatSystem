package com.limingyi.service;

import com.limingyi.entity.Collect;

public interface CollectService {
	
	/**
	 * 查找该主题是否被收藏
	 */
	Collect isCollect(Integer uid,Integer tid);
	/**
	 * 取消收藏
	 */
    Integer delete(Integer uid,Integer tid);
    /**
     * 添加收藏
     */
    Integer insert(Collect collet);
    /**
	 * 统技用户收藏话题的数量
	 * @param uid
	 * @return
	 */
	int countByUid(Integer uid);
}
