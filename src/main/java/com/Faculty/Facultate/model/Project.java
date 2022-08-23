package com.Faculty.Facultate.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String project;

    @ManyToOne
    @NotNull
    Professor professor;
}
