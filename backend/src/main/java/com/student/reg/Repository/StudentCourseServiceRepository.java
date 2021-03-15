
package com.student.reg.Repository;

import com.student.reg.entity.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseServiceRepository extends JpaRepository<StudentCourseEntity, Integer> {


}
