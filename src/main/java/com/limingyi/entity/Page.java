package com.limingyi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体
 * @author 李明义
 *
 */
public class Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<?> list;                // list result of this page
    private int currentPage;                // page number 当前页数
    private int pageSize;                // result amount of this page 每页显示多少条数据量
    private long totalPage;                // total page 总共有多少页
    private long totalRow;                // total row 总共有多少条数据量
    
	public Page(List<?> list, int currentPage, int pageSize, long totalRow) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRow = totalRow;
        this.totalPage = totalRow % pageSize == 0 ? totalRow / pageSize : (totalRow / pageSize) + 1;
	}
    
	 /**
     * Return list of this page.
     */
    public List<?> getList() {
        return list;
    }

    /**
     * Return page number.
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Return page size.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Return total page.
     */
    public long getTotalPage() {
        return totalPage;
    }

    /**
     * Return total row.
     */
    public long getTotalRow() {
        return totalRow;
    }

    public boolean isFirstPage() {
        return currentPage == 1;
    }

    public boolean isLastPage() {
        return currentPage == totalPage;
    }

	@Override
	public String toString() {
		return "PageDataBody [list=" + list + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage="
				+ totalPage + ", totalRow=" + totalRow + "]";
	}
    
}
