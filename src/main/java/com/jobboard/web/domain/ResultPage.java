package com.jobboard.web.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ResultPage<T> {
	private List<T> list;
	private Pagination page;
}
