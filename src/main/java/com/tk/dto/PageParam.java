package com.tk.dto;

public class PageParam {

	/**
	 * 每页条数
	 */
	private int pageRows;

	/**
	 * 当前页
	 */
	private int currentPage;

	public int getPageRows() {
		return pageRows;
	}

	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
