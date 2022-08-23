package com.Faculty.Facultate.controller;

import com.Faculty.Facultate.exception.NoGradesException;
import com.Faculty.Facultate.exception.SpecialtyNotFoundException;
import com.Faculty.Facultate.model.Specialty;
import com.Faculty.Facultate.model.Student;
import com.Faculty.Facultate.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("/allStudents/{specialtyId}")
    public List<Student> getAllStudentsBySpecialty(@PathVariable Integer specialtyId) throws SpecialtyNotFoundException {
        return specialtyService.getAllStudentsBySpecialty(specialtyId);
    }

    @GetMapping("/famousSpecialty")
    public Optional<Specialty> getSpecialtyWithMaximumStudents(){
        return specialtyService.getSpecialtyWithMaximumStudents();
    }

    @GetMapping("/generalAverage/{specialtyId}")
    public Integer getAverageFromAllStudentsBySpecialty(@PathVariable Integer specialtyId) throws SpecialtyNotFoundException, NoGradesException {
        return specialtyService.getAverageFromAllStudentsBySpecialty(specialtyId);
    }

}

