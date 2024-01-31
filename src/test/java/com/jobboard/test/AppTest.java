package com.jobboard.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jobboard.recruit.service.RecruitBullService;
import com.jobboard.web.model.Pagination;

public class AppTest {
	RecruitBullService rbService = RecruitBullService.getInstance();
	
	@Test
	@DisplayName("페이징")
	void page() {
		Pagination p = new Pagination(50, 10, 2, 1);
		Map<String, Long> map = new HashMap<>();
		map.put("first", p.getFistIndexItem());
		map.put("last", p.getLastIndexItem());
		
		for(int i=1; i <= p.getTotalPage(); i++) {
			p.setCurrentPage(i);
			System.out.println(i+":" + p.getFistIndexItem() + " ~ " + p.getLastIndexItem());
		}
	}
}