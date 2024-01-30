package com.jobboard.web.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ResultPage<T> {
	private final List<T> list;
	private final Pagination page;
	private final Map<String, String> message;
	
	public ResultPage(List<T> list, Pagination page) {
		this.list = list;
		this.page = page;
		this.message = Map.of();
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
}
