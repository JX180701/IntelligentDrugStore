package org.great.biz;

import java.util.List;

import org.great.entity.User;

public interface UserBiz
{
	 public User login(User user);

	public List<User> findalluser(User user);

	public boolean insertuser(User user);

	public boolean deleteuserbyid(int uid);

	public boolean updateuserbyid(User user);
	
	public int getRoleIdByUserId(User user);
	
	public User finduserinfo(int uid);

	public List<User> specificfind(User user);

	public List<User> finduseraut(User user);
	
	public User findUser(User user);
	
	public boolean updateUserDate(User user);
}
