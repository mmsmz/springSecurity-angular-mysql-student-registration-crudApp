package com.student.reg.controller;

import com.student.reg.dto.CourseDTO;
import com.student.reg.dto.ResponseDTO;
import com.student.reg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    CourseService courseService;

//    @GetMapping("/")
//    public String login(){
//        return "authenticating successfully 123";
//    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getAuthorities().toString();
    }



    /*
     * To Add Course
     *
     * @param CourseId
     *
     * @param name return successfully inserted
     */
    @PostMapping(value = "/addCourse", produces = "application/json")
    public ResponseEntity<ResponseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.addCourse(courseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*
     * To get a Course
     *
     * @param Courseid
     *
     * @param name return successfully inserted
     */
    @GetMapping(value = "/getCourseById", produces = "application/json")
    public ResponseEntity<ResponseDTO> getCourseById(@RequestParam Integer courseId) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.getCourseById(courseId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*
     * To get all Courses return all Course
     */
    @GetMapping(value = "/getAllCourses", produces = "application/json")
    public ResponseEntity<ResponseDTO> getAllCourse() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.getAllCourses());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*
     * To update Course
     *
     * @param Courseid
     *
     * @param name return successfully updated
     */
    @PutMapping(value = "/updateCourse", produces = "application/json")
    public ResponseEntity<ResponseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.updateCourse(courseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*
     * To delete Course
     *
     * @param CourseId
     *
     * @param name return successfully deleted
     */
    @DeleteMapping(value = "/deleteCourse", produces = "application/json")
    public ResponseEntity<ResponseDTO> deleteCourse(@RequestBody CourseDTO courseDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.deleteCourse(courseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
