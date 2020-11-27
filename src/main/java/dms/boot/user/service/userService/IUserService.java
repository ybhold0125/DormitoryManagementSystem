package dms.boot.user.service.userService;

import java.util.Map;

import dms.boot.user.domain.User;

public interface IUserService {
	public User queryUserByUserId(String userId);
	
	public Map<String, Object> queryUserByUsername(User user);
}
