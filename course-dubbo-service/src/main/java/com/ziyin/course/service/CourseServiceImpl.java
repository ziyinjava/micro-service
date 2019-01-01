package com.ziyin.course.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ziyin.course.dto.CourseDTO;
import com.ziyin.course.mapper.CourseMapper;
import com.ziyin.thrift.user.UserInfo;
import com.ziyin.thrift.user.dto.TeacherDTO;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ziyin
 @create 2018-12-2018/12/30-14:43
 */
@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	private ServiceProvider serviceProvider;

	@Override
	public List<CourseDTO> courseList() {

		List<CourseDTO> courseDTOS = courseMapper.listCourse();
		if(courseDTOS!=null) {
			for(CourseDTO courseDTO : courseDTOS) {
				Integer teacherId = courseMapper.getCourseTeacher(courseDTO.getId());
				if(teacherId!=null) {
					try {
						UserInfo userInfo = serviceProvider.getUserService().getTeacherById(teacherId);
						courseDTO.setTeacherDTO(trans2Teacher(userInfo));
					} catch (TException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}
		return courseDTOS;
	}

	private TeacherDTO trans2Teacher(UserInfo userInfo) {
		TeacherDTO teacherDTO = new TeacherDTO();
		BeanUtils.copyProperties(userInfo, teacherDTO);
		return teacherDTO;
	}
}

