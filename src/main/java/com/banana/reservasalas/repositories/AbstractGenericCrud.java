package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.ValueObject;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.validation.Valid;
import java.util.List;

public abstract class AbstractGenericCrud<T extends ValueObject> {

    protected abstract GenericRepository<T> getRepository();

    public T findById(Long id) {
        return getRepository().find(id);
    }

    public List<T> findAll() {
        return getRepository().getAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T insert(@Valid T valueObject) {
        return getRepository().insert(valueObject);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(@Valid T valueObject) {
        return getRepository().update(valueObject);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Long id) {
        getRepository().delete(id);
    }

}
