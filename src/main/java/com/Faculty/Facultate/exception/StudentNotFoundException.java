package com.Faculty.Facultate.exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException() {
        super("The student that you are looking for is not existent!");
    }
}
