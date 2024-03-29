package com.jobboard.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ResultMessage<T> {
	private final T value;
	private final Map<String, Object> message;
	
	public ResultMessage(T value) {
		this.value = value;
		this.message = Map.of();
	}
	
	public boolean isEmpty() {
		return this.value == null;
	}
}
