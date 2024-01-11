package com.job.mvc.dao;

import java.util.Optional;

public interface CuidDAO<T, ID> {
	
	int save(T obj);
	Optional<T> findById(ID primaryKey);
}
