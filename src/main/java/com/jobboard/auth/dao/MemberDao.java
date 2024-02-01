package com.jobboard.auth.dao;

import java.util.Optional;

public interface MemberDao<T> {
	public Optional<T> signIn(String username, String password);
	public boolean signUp(T param);
	public int checkUsernameDuplicate(String username);
}
