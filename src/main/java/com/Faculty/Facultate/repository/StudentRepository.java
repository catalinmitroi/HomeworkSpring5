package com.Faculty.Facultate.repository;

import com.Faculty.Facultate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
