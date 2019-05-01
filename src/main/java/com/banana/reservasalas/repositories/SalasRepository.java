package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.entidades.Salas;
import com.banana.reservasalas.utils.enums.PersistenceAction;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

import static com.banana.reservasalas.utils.enums.PersistenceAction.DELETE;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class SalasRepository extends AbstractGenericCrud<Salas> {

    @Inject
    private GenericRepository<Salas> repository;

    @Inject
    private ReservasRepository reservasRepository;

    @Override
    public GenericRepository<Salas> getRepository() {
        return repository;
    }

    public List<Salas> findByLocal(Long idLocal) {
        return getRepository().getByCriteria(" local.id = " + idLocal);
    }

    @Override
    public void applyBusinessRules(Salas sala, PersistenceAction action) {

        if (action.equals(DELETE)) {
            if (reservasRepository.getRepository().existsByCriteria(" sala.id = " + sala.getId())) {
                throw new BusinessException("Registro não pode ser excluído pois é referenciado no cadastro de reservas");
            }
        }

    }
}
