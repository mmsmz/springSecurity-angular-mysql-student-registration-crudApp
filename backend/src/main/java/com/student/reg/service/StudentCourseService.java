package com.student.reg.service;

import com.student.reg.dto.StudentCourseDTO;
import com.student.reg.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCourseService {
	String addStudentCourse(StudentCourseDTO studentCourseDTO);

	List<StudentCourseDTO> getStudentCourseById(Integer studentCourseId);

//	List<StudentCourseDTO> getAllStudentCourse();

	String updateStudentCourse(StudentCourseDTO studentCourseDTO);

	String deleteStudentCourse(StudentCourseDTO studentCourseDTO);
}
