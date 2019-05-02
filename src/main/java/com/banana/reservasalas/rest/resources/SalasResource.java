package com.banana.reservasalas.rest.resources;

import com.banana.reservasalas.models.entidades.Salas;
import com.banana.reservasalas.repositories.SalasRepository;
import com.banana.reservasalas.rest.AbstractCrudResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

    @GET
    @Path("local/{idLocal}")
    public List<Salas> getSalasFromLocal(@PathParam("idLocal") Long idLocal) {
        return repository.findByLocal(idLocal);
    }

}
