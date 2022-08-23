package com.Faculty.Facultate.controller;

import com.Faculty.Facultate.exception.NoGradesException;
import com.Faculty.Facultate.exception.StudentNotFoundException;
import com.Faculty.Facultate.model.Grade;
import com.Faculty.Facultate.model.Student;
import com.Faculty.Facultate.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/grades/{studentId}")
    public List<Grade> getAllGradesByStudent(@PathVariable Integer studentId) throws StudentNotFoundException {
        return studentService.getAllGradesByStudent(studentId);
    }


    @PostMapping("/addGrade/{studentId}")
    public void addGrade(@RequestBody Grade grade,@PathVariable Integer studentId) throws StudentNotFoundException {
        studentService.addGrade(grade, studentId);
    }

    @GetMapping("/allWithGradeGraterThanEight")
    public List<Student> getAllStudentsGradeGraterThanEight(){
        return studentService.getAllStudentsGradeGraterThanEight();
    }

    @GetMapping("/highestAverage")
    public Student getStudentWithHighestAverage() throws NoGradesException {
        return studentService.getStudentWithHighestAverage();
    }

    @GetMapping("/highestAverage/{specialityId}")
    public Student getStudentWithHighestAverageBySpecialty(@PathVariable Integer specialtyId) {
        return studentService.getStudentWithHighestAverageBySpecialty(specialtyId);
    }

}
