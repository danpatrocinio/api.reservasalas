package com.banana.reservasalas.repositories;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.banana.reservasalas.models.entidades.Salas;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class SalasRepository extends AbstractGenericCrud<Salas> {

    @Inject
    private GenericRepository<Salas> repository;

    @Override
    public GenericRepository<Salas> getRepository() {
        return repository;
    }
}
