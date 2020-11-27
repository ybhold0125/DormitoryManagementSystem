package dms.boot.user.dao.identityDao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dms.boot.user.domain.Identity;

@Mapper
public interface IIdentityDao {
	/**
	 * 	查询身份信息(下拉)
	 * @return
	 */
	@Select("SELECT * FROM identity")
	public List<Identity> queryidentityForSelect();
}
