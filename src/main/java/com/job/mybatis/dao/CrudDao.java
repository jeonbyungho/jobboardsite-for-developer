package com.job.mybatis.dao;

import java.util.Optional;

public interface CrudDao<T, PK> {
	int insert(T obj);
	Optional<T> findById(PK pk);
//	int update();
//	int delete();
}
