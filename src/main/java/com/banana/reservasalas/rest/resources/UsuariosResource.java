package com.banana.reservasalas.rest.resources;

import com.banana.reservasalas.models.Usuarios;
import com.banana.reservasalas.repositories.UsuariosRepository;
import com.banana.reservasalas.rest.AbstractCrudResource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosResource extends AbstractCrudResource<Usuarios> {

    @Inject
    private UsuariosRepository repository;

    @Override
    public UsuariosRepository getRepository() {
        return repository;
    }
}
