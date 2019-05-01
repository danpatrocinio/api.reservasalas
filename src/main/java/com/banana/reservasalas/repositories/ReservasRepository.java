package com.banana.reservasalas.repositories;

import com.banana.reservasalas.models.entidades.Reservas;
import com.banana.reservasalas.utils.enums.PersistenceAction;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.text.SimpleDateFormat;

import static com.banana.reservasalas.utils.enums.PersistenceAction.INSERT;
import static com.banana.reservasalas.utils.enums.PersistenceAction.UPDATE;
import static com.banana.reservasalas.utils.enums.SimNao.sim;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ReservasRepository extends AbstractGenericCrud<Reservas> {

    @Inject
    private GenericRepository<Reservas> repository;

    @Override
    public GenericRepository<Reservas> getRepository() {
        return repository;
    }

    @Override
    public void applyBusinessRules(Reservas reserva, PersistenceAction action) {

        if (action.equals(INSERT) || action.equals(UPDATE)) {

            if (sim(reserva.getCafe()) && (reserva.getQtdPessoas() == null || reserva.getQtdPessoas().compareTo(1) < 0)) {
                throw new BusinessException("Necessário informar a quantidade de pessoas para o café");
            }

            if (!reserva.getDhFinal().after(reserva.getDhInicio())) {
                throw new BusinessException("A data e hora final da reserva deve ser posterior a data de início");
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dhInicio = formatter.format(reserva.getDhInicio());
            String dhFinal = formatter.format(reserva.getDhFinal());

            String criteria = String.format("id_reserva <> %d AND id_sala = %d AND ('%s' between dh_inicio and dh_final and '%s' <> dh_final or ('%s' between dh_inicio and dh_final and '%s' <> dh_inicio))",
                    reserva.getId(), reserva.getSala().getId(), dhInicio, dhInicio, dhFinal, dhFinal);

            boolean existeConflito = repository.existsByCriteria(criteria);

            if (existeConflito) {
                throw new BusinessException("A data e hora informada conflita com outra reserva desta sala");
            }

        }
    }

}
