package com.Faculty.Facultate.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String subject;
    @NotNull
    Integer creditPoints;

    @ManyToOne
    @NotNull
    Specialty specialty;

    @ManyToOne
    @NotNull
    Professor professor;
}
