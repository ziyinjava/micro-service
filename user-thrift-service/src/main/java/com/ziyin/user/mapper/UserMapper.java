package com.ziyin.user.mapper;

import com.ziyin.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ziyin
 @create 2018-12-2018/12/29-22:37
 */
@Mapper
public interface UserMapper {

	@Select("select id,username, password, real_name," +
			"mobile, email from pe_user where id=#{id}")
	UserInfo getUserById(@Param("id")int id);


	@Select("select id,username, password, real_name," +
			"mobile, email from pe_user where username=#{username}")
	UserInfo getUserByName(@Param("username")String username);


	@Insert("insert into pe_user (username, password, real_name, mobile, email)" +
			"values (#{u.username}, #{u.password}, #{u.realName}, #{u.mobile}, #{u.email})")
	void registerUser(@Param("u") UserInfo userInfo);


	@Select("select u.id,u.username,u.password,u.real_name," +
			"u.mobile,u.email,t.intro,t.stars from pe_user u," +
			"pe_teacher t where u.id=#{id} " +
			"and u.id=t.user_id")
	UserInfo getTeacherById(@Param("id")int id);
}
