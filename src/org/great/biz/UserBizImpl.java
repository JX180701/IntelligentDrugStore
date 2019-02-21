package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.aop.SystemLog;
import org.great.entity.User;
import org.great.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service("userBiz")
public class UserBizImpl implements UserBiz
{
	@Resource
	private UserMapper userMapper;


	@Override
	public User login(User user)
	{
		 return userMapper.findByUserNameAndPassword(user);

	}


	@Override
	public List<User> findalluser(User user)
	{
		// TODO Auto-generated method stub
		return userMapper.findalluser( user);
	}


	@Override
	public boolean insertuser(User user)
	{
		// TODO Auto-generated method stub
		return userMapper.insertuser(user);
	}
	@Override
	public boolean deleteuserbyid(int uid)
	{
		// TODO Auto-generated method stub
		return userMapper.deleteuserbyid(uid);
	}
	
	@Override
	public boolean updateuserbyid(User user)
	{
		// TODO Auto-generated method stub
		return userMapper.updateuserbyid(user);
	}


	@Override
	public int getRoleIdByUserId(User user) {
		// TODO Auto-generated method stub
		return userMapper.getRoleIdByUserId(user);
	}
	
	@Override
	public User finduserinfo(int uid)
	{
		// TODO Auto-generated method stub
		return userMapper.finduserinfo(uid);
	}


	@Override
	public List<User> specificfind(User user)
	{
		// TODO Auto-generated method stub
		return userMapper.specificfind(user);
	}


	@Override
	public List<User> finduseraut(User user)
	{
		// TODO Auto-generated method stub
		return userMapper.finduseraut(user);
	}


	@Override
	public User findUser(User user)
	{
		return userMapper.findUser(user);
	}


	@Override
	public boolean updateUserDate(User user)
	{
		// TODO Auto-generated method stub
		return userMapper.updateUserDate(user);
	}
}
