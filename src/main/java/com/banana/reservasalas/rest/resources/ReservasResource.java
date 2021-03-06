package com.banana.reservasalas.rest.resources;

import com.banana.reservasalas.models.entidades.Reservas;
import com.banana.reservasalas.repositories.ReservasRepository;
import com.banana.reservasalas.rest.AbstractCrudResource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("reservas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservasResource extends AbstractCrudResource<Reservas> {

    @Inject
    private ReservasRepository repository;

    @Override
    public ReservasRepository getRepository() {
        return repository;
    }

}
