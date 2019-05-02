package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.entidades.Usuarios;
import com.banana.reservasalas.utils.enums.PersistenceAction;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import static com.banana.reservasalas.utils.enums.PersistenceAction.*;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuariosRepository extends AbstractGenericCrud<Usuarios> {

    @Inject
    private GenericRepository<Usuarios> repository;

    @Inject
    private ReservasRepository reservasRepository;

    @Override
    public GenericRepository<Usuarios> getRepository() {
        return repository;
    }

    @Override
    public void applyBusinessRules(Usuarios usuario, PersistenceAction action) {
        if (action.equals(INSERT) || action.equals(UPDATE)) {

            if (repository.existsByCriteria("email = '".concat(usuario.getEmail()).concat("' AND id <> " + usuario.getId()))) {
                throw new BusinessException("E-mail já cadastrado para outro usuário");
            }

        }

        if (action.equals(DELETE)) {
            if (reservasRepository.getRepository().existsByCriteria(" usuario.id = " + usuario.getId())) {
                throw new BusinessException("Registro não pode ser excluído pois é referenciado no cadastro de reservas");
            }
        }

    }
}
