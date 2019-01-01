package com.ziyin.course.dto;

import com.ziyin.thrift.user.dto.TeacherDTO;

import java.io.Serializable;

/**
 * @author ziyin
 @create 2018-12-2018/12/30-13:53
 */
public class CourseDTO implements Serializable{

	private int id;
	private String title;
	private String description;
	private TeacherDTO teacherDTO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TeacherDTO getTeacherDTO() {
		return teacherDTO;
	}

	public void setTeacherDTO(TeacherDTO teacherDTO) {
		this.teacherDTO = teacherDTO;
	}
}
