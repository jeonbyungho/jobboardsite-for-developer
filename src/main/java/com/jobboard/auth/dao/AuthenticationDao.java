package com.jobboard.auth.dao;

import java.util.Map;
import java.util.Optional;

public interface AuthenticationDao<T> {
	public Optional<T> signIn(String username, String password);
	public int signUp(Map<String, Object> parameters);
}
