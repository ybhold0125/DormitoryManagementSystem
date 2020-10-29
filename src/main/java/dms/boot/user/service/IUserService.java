package dms.boot.user.service;

import dms.boot.user.domain.User;

public interface IUserService {
	public User queryUserByUserId(String userId);
	
	public User queryUserByUsername(String username);
}
