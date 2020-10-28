package dms.boot.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dms.boot.user.dao.IUserDao;
import dms.boot.user.domain.User;
import dms.boot.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao iUserDao;

	@Override
	public User queryUserByUserId(String userId) {
		return iUserDao.queryUserById(userId);
	}

}
