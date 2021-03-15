package com.student.reg.controller;


import com.student.reg.dto.ResponseDTO;
import com.student.reg.dto.StudentCourseDTO;
import com.student.reg.dto.UserDTO;
import com.student.reg.service.CourseService;
import com.student.reg.service.StudentCourseService;
import com.student.reg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StudentCourseController {

    @Autowired
    StudentCourseService studentCourseService;

    @PostMapping(value = "/addStudentCourse", produces = "application/json")
    public ResponseEntity<ResponseDTO> addStudentCourse(@RequestBody StudentCourseDTO studentCourseDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(studentCourseService.addStudentCourse(studentCourseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getStudentCourseById", produces = "application/json")
    public ResponseEntity<ResponseDTO> getStudentCourseById(@RequestParam Integer studentCourseId) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(studentCourseService.getStudentCourseById(studentCourseId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


//    @GetMapping(value = "/getAllStudentCourses", produces = "application/json")
//    public ResponseEntity<ResponseDTO> getAllStudentCourse() {
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setMessage("Success");
//        responseDTO.setData(studentCourseService.getAllStudentCourse());
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }

    @PostMapping(value = "/updateStudentCourse", produces = "application/json")
    public ResponseEntity<ResponseDTO> updateStudentCourse(@RequestBody StudentCourseDTO studentCourseDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(studentCourseService.updateStudentCourse(studentCourseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }



    @PostMapping(value = "/deleteStudentCourse", produces = "application/json")
    public ResponseEntity<ResponseDTO> deleteStudentCourse(@RequestBody StudentCourseDTO studentCourseDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(studentCourseService.deleteStudentCourse(studentCourseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
