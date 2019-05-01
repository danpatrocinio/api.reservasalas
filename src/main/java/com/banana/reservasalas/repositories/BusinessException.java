package com.banana.reservasalas.repositories;

import javax.persistence.PersistenceException;

public class BusinessException extends PersistenceException {

    public BusinessException(String message) {
        super(message);
    }

}
