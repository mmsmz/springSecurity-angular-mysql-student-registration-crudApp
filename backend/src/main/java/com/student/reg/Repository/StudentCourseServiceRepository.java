
package com.student.reg.Repository;

import com.student.reg.entity.CourseEntity;
import com.student.reg.entity.StudentCourseEntity;
import com.student.reg.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentCourseServiceRepository extends JpaRepository<StudentCourseEntity, Integer> {

}
