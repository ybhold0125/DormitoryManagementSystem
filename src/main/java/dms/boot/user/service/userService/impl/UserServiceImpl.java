package dms.boot.user.service.userService.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dms.boot.user.dao.userDao.IUserDao;
import dms.boot.user.domain.User;
import dms.boot.user.service.userService.IUserService;
import dms.boot.util.JwtUtil;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao iUserDao;

	@Override
	public User queryUserByUserId(String userId) {
		return iUserDao.queryUserById(userId);
	}

	@Override
	public Map<String, Object> queryUserByUsername(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		User userInfo = iUserDao.queryUserByUsernameWithIdentity(user.getUsername(), user.getIdentity());
		if(userInfo == null || !userInfo.getPassword().equals(user.getPassword())) {
			map.put("status", "false");
			map.put("msg", "登录失败，账号或密码不存在");
			return map;
		}
		String token = JwtUtil.getToken(userInfo);
		map.put("status", "true");
		map.put("msg", "登录成功");
		map.put("token", token);
		map.put("user", userInfo);
		return map;
	}
}
