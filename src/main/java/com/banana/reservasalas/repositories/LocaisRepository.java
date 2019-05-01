package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.entidades.Locais;
import com.banana.reservasalas.utils.enums.PersistenceAction;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import static com.banana.reservasalas.utils.enums.PersistenceAction.DELETE;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LocaisRepository extends AbstractGenericCrud<Locais> {

    @Inject
    private GenericRepository<Locais> repository;

    @Inject
    private SalasRepository salasRepository;

    @Override
    public GenericRepository<Locais> getRepository() {
        return repository;
    }


    @Override
    public void applyBusinessRules(Locais local, PersistenceAction action) {

        if (action.equals(DELETE)) {
            if (salasRepository.getRepository().existsByCriteria(" local.id = " + local.getId())) {
                throw new BusinessException("Registro não pode ser excluído pois é referenciado no cadastro de salas");
            }
        }
    }
}
