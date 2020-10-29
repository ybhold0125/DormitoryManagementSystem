package dms.boot.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dms.boot.user.domain.User;

@Mapper
public interface IUserDao {
	/**
	 * 根据userId查询用户记录
	 * 
	 * @param userId
	 * @return
	 */
	@Select("SELECT * FROM user WHERE userId=#{userId}")
	public User queryUserById(String userId);

	/**
	 * 根据username查询用户记录
	 * 
	 * @param username
	 * @return
	 */
	@Select("SELECT * FROM user WHERE username=#{username}")
	public User queryUserByUsername(String username);
}
