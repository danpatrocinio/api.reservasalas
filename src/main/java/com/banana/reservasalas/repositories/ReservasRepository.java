package com.banana.reservasalas.repositories;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.banana.reservasalas.models.Reservas;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ReservasRepository extends AbstractGenericCrud<Reservas> {

    @Inject
    private GenericRepository<Reservas> repository;

    @Override
    public GenericRepository<Reservas> getRepository() {
        return repository;
    }
}
