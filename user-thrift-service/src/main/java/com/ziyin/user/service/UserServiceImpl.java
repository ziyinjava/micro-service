package com.ziyin.user.service;

import com.ziyin.thrift.user.UserInfo;
import com.ziyin.thrift.user.UserService;
import com.ziyin.user.mapper.UserMapper;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ziyin
 @create 2018-12-2018/12/29-22:12
 */
@Service
public class UserServiceImpl implements UserService.Iface {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserInfo getUserById(int id) throws TException {
		return userMapper.getUserById(id);
	}

	@Override
	public UserInfo getUserByName(String username) throws TException {
		return userMapper.getUserByName(username);
	}

	@Override
	public UserInfo getTeacherById(int id) throws TException {
		return userMapper.getTeacherById(id);
	}

	@Override
	public void registerUser(UserInfo userInfo) throws TException {
		 userMapper.registerUser(userInfo);
	}
}
