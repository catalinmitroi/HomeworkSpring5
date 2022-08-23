package com.Faculty.Facultate.service;

import com.Faculty.Facultate.exception.ProfessorNotFoundException;
import com.Faculty.Facultate.model.Course;
import com.Faculty.Facultate.model.Professor;
import com.Faculty.Facultate.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public List<Course> getAllCourseByProfessor(Integer professorId) throws ProfessorNotFoundException {
        Professor p = professorRepository.findById(professorId).get();
        if(p == null){
            throw new ProfessorNotFoundException();
        } else {
            return p.getCourses();
        }

    }
}
