package dms.boot.user.dao.userDao;

import org.apache.ibatis.annotations.Insert;
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
	@Select("SELECT * FROM user WHERE user_id=#{userId}")
	public User queryUserById(String userId);

	/**
	 * 根据username查询用户记录
	 * 
	 * @param username
	 * @return
	 */
	@Select("SELECT * FROM user WHERE username=#{username}")
	public User queryUserByUsername(String username);
	
	/**
	 * 	插入用户
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO user(user_id, username, password, identity) VALUES(null, #{username}, #{password}, #{identity})")
	public int insertUser(User user);
}
