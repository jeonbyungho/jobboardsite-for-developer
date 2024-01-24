package com.jobboard.recruit.domain;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class Pagination {
	private long totalItem;			// 항목의 총 개수
	private int currentPageNo;		// 현재 페이지
	private int numberItem;			// 한 페이지의 표시될 항목 개수
	private int pageSize;			// 한 페이지 그룹의 최대 개수
	
	public Pagination(long totalItem, int currentPageNo, int numberItem, int pageSize) {
		this.totalItem = totalItem;
		this.currentPageNo = currentPageNo;
		this.numberItem = numberItem;
		this.pageSize = pageSize;
	}
	
	public Pagination(long totalCount, int current) {
		this(totalCount, current, 16, 8);
	}
	
	public int getTotalPage() {
		float num = (float) this.totalItem / this.numberItem;
		return (int) Math.ceil(num);
	}
	
	public int getCurrentGroupNo() {
		float num = (float) this.currentPageNo / this.pageSize;
		return (int) Math.ceil(num);
	}
	
	public int getStartPageNo() {
		int currentGroupNo = getCurrentGroupNo();
		return (currentGroupNo - 1) * pageSize + 1;
	}
	
	public int getLastPageNo() {
		int currentGroupNo = getCurrentGroupNo();
		int totalPage = getTotalPage();
		int lastNo = currentGroupNo * pageSize;
		return lastNo < totalPage ? lastNo : totalPage;
	}
	
}