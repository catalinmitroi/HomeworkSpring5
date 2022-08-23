package com.Faculty.Facultate.exception;

public class ProfessorNotFoundException extends Exception {
    public ProfessorNotFoundException(){
        super("The professor are looking for is not existent!");
    }
}
