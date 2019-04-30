package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.entidades.Locais;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LocaisRepository extends AbstractGenericCrud<Locais> {

    @Inject
    private GenericRepository<Locais> repository;

    @Override
    public GenericRepository<Locais> getRepository() {
        return repository;
    }
}
