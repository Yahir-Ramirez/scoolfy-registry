package com.scoolfy.registry.persistence.error;

import com.scoolfy.registry.domain.error.DomainException;

public class StudentAlreadyExistsException extends DomainException {
    public StudentAlreadyExistsException(String idStudent) {
        super("Student with ID " + idStudent + " already exists");
    }
}
