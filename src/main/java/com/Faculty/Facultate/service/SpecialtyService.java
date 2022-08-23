package com.Faculty.Facultate.service;

import com.Faculty.Facultate.exception.NoGradesException;
import com.Faculty.Facultate.exception.SpecialtyNotFoundException;
import com.Faculty.Facultate.model.Specialty;
import com.Faculty.Facultate.model.Student;
import com.Faculty.Facultate.repository.CourseRepository;
import com.Faculty.Facultate.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    private  final CourseRepository courseRepository;

    public List<Student> getAllStudentsBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException {
        Specialty s = specialtyRepository.findById(specialtyId).get();

        if(s==null){
            throw new SpecialtyNotFoundException();
        }
        else {
            return s.getStudents();
        }
    }

// returnati specializarea cu cei mai multi student

    public Optional<Specialty> getSpecialtyWithMaximumStudents(){
        return specialtyRepository.findAll().stream()
                .filter(specialty -> {
                    int maxStudents = 0;
                    for(int i=0;i<specialtyRepository.count();i++){
                        if(specialty.getStudents().size() > maxStudents){
                            maxStudents = specialty.getStudents().size();
                        }
                    }
                    return specialty.getStudents().size() == maxStudents ;
                })
                .findFirst();
    }


// returnati  media la o specializare (media notelor tuturor studentilor)

    public Integer getAverageFromAllStudentsBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException, NoGradesException {
        Specialty s = specialtyRepository.findById(specialtyId).get();

        if(s == null){
            throw new SpecialtyNotFoundException();
        } else {

            List<Student> listStudents = s.getStudents();

            int avg = 0;
            for(int i=0;i<listStudents.size();i++){
                avg += listStudents.get(i).getAnnualAverageGrade();
            }
            return avg/listStudents.size();
        }

    }



}
