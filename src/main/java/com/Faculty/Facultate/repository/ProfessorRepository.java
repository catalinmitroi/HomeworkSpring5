package com.Faculty.Facultate.repository;

import com.Faculty.Facultate.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
