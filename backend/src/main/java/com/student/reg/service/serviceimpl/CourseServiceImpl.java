package com.student.reg.service.serviceimpl;

import com.student.reg.dto.CourseDTO;
import com.student.reg.Repository.CourseServiceRepository;
import com.student.reg.entity.CourseEntity;
import com.student.reg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseServiceRepository courseServiceRepository;

	/*
	 * To Add course
	 *
	 * @param courseId
	 * @param courseName
	 * @param coursePrice
	 * return successfully inserted
	 */
	@Override
	public String addCourse(CourseDTO courseDTO) {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseID(courseDTO.getCourseID());
		courseEntity.setCourseName(courseDTO.getCourseName());
		courseEntity.setCoursePrice(courseDTO.getCoursePrice());
		courseServiceRepository.save(courseEntity);
		return "Inserted";
	}

	@Override
	public List<CourseDTO> getCourseById(Integer courseId) {
		CourseEntity courseEntity = courseServiceRepository.findById(courseId).get();
		CourseDTO courseDTO=new CourseDTO();
		courseDTO.setCourseID(courseEntity.getCourseID());
		courseDTO.setCourseName(courseEntity.getCourseName());
		courseDTO.setCoursePrice(courseEntity.getCoursePrice());
		List<CourseDTO> list=new ArrayList<>();
		list.add(courseDTO);
		return list;
	}

	@Override
	public List<CourseDTO> getAllCourses() {
		List<CourseEntity> users = courseServiceRepository.findAll();
		List<CourseDTO> userDTOs = new ArrayList<CourseDTO>();
		for (CourseEntity courseEntity : users) {
			CourseDTO courseDTO = new CourseDTO();
			courseDTO.setCourseID(courseEntity.getCourseID());
			courseDTO.setCourseName(courseEntity.getCourseName());
			courseDTO.setCoursePrice(courseEntity.getCoursePrice());
			userDTOs.add(courseDTO);
		}
		return userDTOs;
	}

	@Override
	public String updateCourse(CourseDTO courseDTO) {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseID(courseDTO.getCourseID());
		courseEntity.setCourseName(courseDTO.getCourseName());
		courseEntity.setCoursePrice(courseDTO.getCoursePrice());
		courseServiceRepository.save(courseEntity);
		return "Updated";
	}

	@Override
	public String deleteCourse(CourseDTO courseDTO) {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseID(courseDTO.getCourseID());
		courseEntity.setCourseName(courseDTO.getCourseName());
		courseEntity.setCoursePrice(courseDTO.getCoursePrice());
		courseServiceRepository.delete(courseEntity);
		return "Deleted";
	}

}
