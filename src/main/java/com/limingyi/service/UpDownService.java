package com.limingyi.service;

import com.limingyi.entity.UpDown;

public interface UpDownService {
    /**
     * 插入点赞记录
     * @param niceDetail
     * @return
     */
    Integer insertNiceDetail(UpDown niceDetail);
 
    /**
     * 删除点赞记录
     * @param id
     * @return
     */
    Integer deleteNiceDetail(Integer id);
 

  /**
     * 根据用户id和文章id信息查询点赞记录
     * @param niceDetail
     * @return
     */
    UpDown findNiceDetail(Integer uid,Integer tid);

}

