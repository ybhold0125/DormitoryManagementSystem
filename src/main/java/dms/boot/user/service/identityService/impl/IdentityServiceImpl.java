package dms.boot.user.service.identityService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dms.boot.user.dao.identityDao.IIdentityDao;
import dms.boot.user.domain.Identity;
import dms.boot.user.service.identityService.IIdentityService;

@Service
public class IdentityServiceImpl implements IIdentityService {
	@Autowired
	private IIdentityDao iIdentityDao;

	@Override
	public List<Identity> queryIdentity() {
		return iIdentityDao.queryidentityForSelect();
	}

}
