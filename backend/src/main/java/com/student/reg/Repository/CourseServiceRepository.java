package com.student.reg.Repository;

import com.student.reg.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseServiceRepository extends JpaRepository<CourseEntity,Integer> {
}
