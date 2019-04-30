package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.Usuarios;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuariosRepository extends AbstractGenericCrud<Usuarios> {

    @Inject
    private GenericRepository<Usuarios> repository;

    @Override
    public GenericRepository<Usuarios> getRepository() {
        return repository;
    }

}
