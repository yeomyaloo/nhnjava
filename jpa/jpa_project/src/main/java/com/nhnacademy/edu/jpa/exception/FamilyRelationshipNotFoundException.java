package com.nhnacademy.edu.jpa.exception;

public class FamilyRelationshipNotFoundException extends RuntimeException {
    public FamilyRelationshipNotFoundException() {
        super("not found relationship");
    }
}
