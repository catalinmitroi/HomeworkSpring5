package com.Faculty.Facultate.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String nameSpecialty;

    @OneToMany
    @NotNull
    List<Student> students =new ArrayList<Student>();

    @OneToMany
    @NotNull
    List<Course> courses = new ArrayList<Course>();
}
