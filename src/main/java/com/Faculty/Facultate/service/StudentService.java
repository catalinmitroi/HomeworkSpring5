package com.Faculty.Facultate.service;

import com.Faculty.Facultate.exception.NoGradesException;
import com.Faculty.Facultate.exception.StudentNotFoundException;
import com.Faculty.Facultate.model.Grade;
import com.Faculty.Facultate.model.Specialty;
import com.Faculty.Facultate.model.Student;
import com.Faculty.Facultate.repository.SpecialtyRepository;
import com.Faculty.Facultate.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final SpecialtyRepository specialtyRepository;

    public void addGrade(Grade grade, Integer studentId) throws StudentNotFoundException {
        Student st  = studentRepository.findById(studentId).get();
        if(st == null){
            throw new StudentNotFoundException();
        } else {
            st.getGrades().add(grade);
            studentRepository.save(st);
        }
    }

    public List<Grade> getAllGradesByStudent(Integer userId) throws StudentNotFoundException {
        Student st = studentRepository.findById(userId).get();
        if(st == null){
            throw new StudentNotFoundException();
        }else {
            return st.getGrades();
        }
    }

    public List<Student> getAllStudentsGradeGraterThanEight(){
        return studentRepository.findAll().stream()
                .filter( student -> {
                    try {
                        return student.getAnnualAverageGrade() >= 8;
                    } catch (NoGradesException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

// gasiti studentul cu cea mai mare medie dintre toti studentii

    public Student getStudentWithHighestAverage() throws NoGradesException {
        return studentRepository.findAll().stream()
                .max(Comparator.comparing(student -> {
                    try {
                        return student.getAnnualAverageGrade();
                    } catch (NoGradesException e) {
                        throw new RuntimeException(e);
                    }
                }))
                .get();
    }

// gasiti studentul cu cea mai mare medie de la o anumita specializare

    public Student getStudentWithHighestAverageBySpecialty(Integer specialtyId){
        Specialty s = specialtyRepository.findById(specialtyId).get();
        return studentRepository.findAll().stream()
                .filter(student -> student.getSpecialty() == s)
                .max(Comparator.comparing(student -> {
                    try {
                        return student.getAnnualAverageGrade();
                    } catch (NoGradesException e) {
                        throw new RuntimeException(e);
                    }
                }))
                .get();


    }
}
