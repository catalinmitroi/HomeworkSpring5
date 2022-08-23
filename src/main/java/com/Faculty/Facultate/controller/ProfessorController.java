package com.Faculty.Facultate.controller;

import com.Faculty.Facultate.exception.ProfessorNotFoundException;
import com.Faculty.Facultate.model.Course;
import com.Faculty.Facultate.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("/allCourses/{professorId}")
    public List<Course> getAllCourseByProfessor(@PathVariable Integer professorId) throws ProfessorNotFoundException {
        return professorService.getAllCourseByProfessor(professorId);
    }

}

