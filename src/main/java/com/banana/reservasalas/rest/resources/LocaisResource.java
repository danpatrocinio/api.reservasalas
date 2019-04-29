package com.banana.reservasalas.rest.resources;

import com.banana.reservasalas.models.Locais;
import com.banana.reservasalas.repositories.LocaisRepository;
import com.banana.reservasalas.rest.AbstractCrudResource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("locais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocaisResource extends AbstractCrudResource<Locais> {

    @Inject
    private LocaisRepository repository;

    @Override
    public LocaisRepository getRepository() {
        return repository;
    }
}
