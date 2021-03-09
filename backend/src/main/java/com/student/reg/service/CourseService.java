package com.student.reg.service;

import com.student.reg.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
	String addCourse(CourseDTO courseDTO);

	List<CourseDTO> getCourseById(Integer courseId);

	List<CourseDTO> getAllCourses();

	String updateCourse(CourseDTO courseDTO);

	String deleteCourse(CourseDTO courseDTO);
}
