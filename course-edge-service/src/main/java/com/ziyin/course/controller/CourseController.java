package com.ziyin.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ziyin.course.dto.CourseDTO;
import com.ziyin.course.service.ICourseService;
import com.ziyin.thrift.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ziyin
 @create 2018-12-2018/12/30-21:23
 */
@Controller
@RequestMapping("/course")
public class CourseController {

	@Reference
	private ICourseService courseService;

	@RequestMapping(value = "/courseList", method = RequestMethod.GET)
	@ResponseBody
	public List<CourseDTO> courseList(HttpServletRequest request) {

		UserDTO user = (UserDTO)request.getAttribute("user");
		System.out.println(user.toString());

		return courseService.courseList();
	}
}
