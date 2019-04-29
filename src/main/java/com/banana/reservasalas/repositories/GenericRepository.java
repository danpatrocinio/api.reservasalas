package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.ValueObject;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import java.util.List;

public class GenericRepository<T extends ValueObject> {

    private final EntityManager em;
    private Class<T> valueObjectType;

    public GenericRepository(EntityManager em, Class<T> valueObjectType) {
        this.em = em;
        this.valueObjectType = valueObjectType;
    }

    public T find(Long id) {
        T valueObject = em.find(valueObjectType, id);
        if (valueObject == null) {
            throw new EntityNotFoundException();
        }
        return valueObject;
    }

    public List<T> getAll() {
        return em.createQuery("select o from ".concat(valueObjectType.getName()).concat(" o"), valueObjectType).getResultList();
    }

    public T insert(T valueObject) {
        em.persist(valueObject);
        return valueObject;
    }

    public T update(T valueObject) {
        T oldValueObject = em.find(valueObjectType, valueObject.getId());
        if (oldValueObject == null) {
            throw new EntityNotFoundException();
        }
        return em.merge(valueObject);
    }

    public void delete(Long id) {
        T valueObject = em.getReference(valueObjectType, id);
        if (valueObject == null) {
            throw new EntityNotFoundException();
        }
        em.remove(valueObject);
    }
}
