package com.student.reg.service;

import com.student.reg.dto.CourseDTO;
import com.student.reg.dto.StudentCourseDTO;
import com.student.reg.dto.UserDTO;
import com.student.reg.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCourseService {
	String addStudentCourse(StudentCourseDTO studentCourseDTO);

	List<CourseDTO> getStudentCourseById(Integer studentID);

//	List<StudentCourseDTO> getAllStudentCourse();

	String updateStudentCourse(StudentCourseDTO studentCourseDTO);

	String deleteStudentCourse(StudentCourseDTO studentCourseDTO);
}
