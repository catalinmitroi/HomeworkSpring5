package com.Faculty.Facultate.exception;

public class NoGradesException extends Exception {
    public NoGradesException() {
        super("The grades list is empty.");
    }
}
