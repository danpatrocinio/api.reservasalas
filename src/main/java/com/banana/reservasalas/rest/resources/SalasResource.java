package com.banana.reservasalas.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.banana.reservasalas.models.Salas;
import com.banana.reservasalas.repositories.SalasRepository;
import com.banana.reservasalas.rest.AbstractCrudResource;

@Path("salas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalasResource extends AbstractCrudResource<Salas> {

    @Inject
    private SalasRepository repository;


    @Override
    public SalasRepository getRepository() {
        return repository;
    }

}
