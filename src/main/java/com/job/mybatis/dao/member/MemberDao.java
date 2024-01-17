package com.job.mybatis.dao.member;

import java.util.Optional;

import com.job.mybatis.dao.CrudDao;

public interface MemberDao<T, PK> extends CrudDao<T, PK>{
	Optional<T> findByUsername(String username);
}