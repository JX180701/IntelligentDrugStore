package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public int addUser(User user);

	public User findByUserNameAndPassword(User user);

	public List<User> findalluser(User user);

	public boolean insertuser(@Param("user")User user);
	
	public boolean deleteuserbyid(int uid);
	
	public boolean updateuserbyid(User user);
	
	public int getRoleIdByUserId(User user);
	
	public User finduserinfo(int uid);

	public List<User> specificfind(User user);

	public List<User> finduseraut(User user);
	
	public User findUser(User user);
	
	public boolean updateUserDate(User user);
}
