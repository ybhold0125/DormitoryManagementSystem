package dms.boot.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dms.boot.user.domain.User;

@Mapper
public interface IUserDao {
	/**
	 * 	根据userId查询用户记录
	 * @param userId
	 * @return
	 */
	@Select("SELECT * FROM user WHRER userId = #{userId}")
	public User queryUserById(String userId);
}	
