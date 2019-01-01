package com.ziyin.course.filter;


import com.ziyin.thrift.user.dto.UserDTO;
import com.ziyin.user.client.LoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ziyin
 @create 2018-12-2018/12/30-21:29
 */
@Component
public class CourseFilter extends LoginFilter{

	@Value("${user.edge.service.addr}")
	private String userEdgeServiceAddr;

	@Override
	protected String userEdgeServiceAddr() {
		return userEdgeServiceAddr;
	}

	@Override
	protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {
		request.setAttribute("user",userDTO);
	}
}
