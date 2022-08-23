package com.Faculty.Facultate.repository;

import com.Faculty.Facultate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
