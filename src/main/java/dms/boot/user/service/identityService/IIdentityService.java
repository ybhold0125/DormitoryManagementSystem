package dms.boot.user.service.identityService;

import java.util.List;

import dms.boot.user.domain.Identity;

public interface IIdentityService {
	/**
	 * 	查询身份信息
	 * @return
	 */
	public List<Identity> queryIdentity();
}
