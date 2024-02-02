package com.jobboard.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @ToString @AllArgsConstructor
public class Pagination {
	/** 게시물의 총 개수 */
	private long totalItem;
	/** 한 페이지에 나타낼 게시물 수 */
	private int countItemPerPage;
	/** 한 화면에 보여질 페이지 개수*/
	private int sizePage;
	/** 현재 페이지 번호 */
	@Setter
	private int currentPage;
	
	public int getTotalPage() {
		return  ((int) totalItem - 1) / countItemPerPage + 1;
	}
	
	public int getStartPageNumber() {
		return ((currentPage - 1) / sizePage) * sizePage + 1;
	}
	
	public int getEndPageNumber() {
		int endPageNumber = getStartPageNumber() + sizePage - 1;
		int totalPage = getTotalPage();
		if(endPageNumber > totalPage) {
			endPageNumber =  totalPage;
		}
		return endPageNumber;
	}
	
	public boolean isPrevPage() {
		return currentPage > sizePage;
	}
	
	public boolean isNextPage() {
		int totalPage = getTotalPage();
		return currentPage - 1 + (totalPage / countItemPerPage) < totalPage;
	}
	
	public long getFistIndexItem() {
		return (currentPage - 1) * countItemPerPage + 1;
	}
	
	public long getLastIndexItem() {
		return currentPage * countItemPerPage;
	}
}
