package com.student.reg.service.serviceimpl;

import com.student.reg.Repository.StudentCourseServiceRepository;
import com.student.reg.dto.StudentCourseDTO;
import com.student.reg.entity.StudentCourseEntity;
import com.student.reg.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentCourseServiceRepository studentCourseServiceRepository;

    /*
     * To Add user
     *
     * @param userid
     * @param name
     * return successfully inserted
     */
    @Override
    public String addStudentCourse(StudentCourseDTO studentCourseDTO) {
        StudentCourseEntity user = new StudentCourseEntity();
//        user.setStudentCourseId(studentCourseDTO.getStudentCourseId());
        user.setUserId(studentCourseDTO.getUserId());
        user.setCourseId(studentCourseDTO.getCourseId());
        studentCourseServiceRepository.save(user);
        return "Inserted";
    }

    @Override
    public List<StudentCourseDTO> getStudentCourseById(Integer studentCourseId) {
        StudentCourseEntity user = studentCourseServiceRepository.findById(studentCourseId).get();
        StudentCourseDTO userDTO=new StudentCourseDTO();
        userDTO.setStudentcourseID(user.getStudentCourseId());
        userDTO.setUserId(user.getUserId());
        userDTO.setCourseId(user.getCourseId());
        List<StudentCourseDTO> list=new ArrayList<>();
        list.add(userDTO);
        return list;
    }
//
//    @Override
//    public List<UserDTO> getAllUsers() {
//        List<UserEntity> users = studentCourseServiceRepository.findAll();
//        List<UserDTO> userDTOs = new ArrayList<>();
//        for (UserEntity user : users) {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setUserId(user.getId());
//            userDTO.setUsername(user.getUsername());
//            userDTO.setEmail(user.getEmail());
//            userDTOs.add(userDTO);
//        }
//        return userDTOs;
//    }

    /*
     * To update user
     *
     * @param userid
     * @param name
     * return successfully updated
     */
    @Override
    public String updateStudentCourse(StudentCourseDTO studentCourseDTO) {
        StudentCourseEntity user = new StudentCourseEntity();
        user.setStudentCourseId(studentCourseDTO.getStudentcourseID());
        user.setUserId(studentCourseDTO.getUserId());
        user.setCourseId(studentCourseDTO.getCourseId());
        studentCourseServiceRepository.save(user);
        return "Updated";
    }


    /*
     * To delete user
     *
     * @param userid
     * @param name
     * return successfully deleted
     */
    @Override
    public String deleteStudentCourse(StudentCourseDTO studentCourseDTO) {
        StudentCourseEntity user = new StudentCourseEntity();
        user.setStudentCourseId(studentCourseDTO.getStudentcourseID());
        user.setUserId(studentCourseDTO.getUserId());
        user.setCourseId(studentCourseDTO.getCourseId());
        studentCourseServiceRepository.delete(user);
        return "Deleted";
    }
}
