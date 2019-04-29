package com.banana.reservasalas.rest;

import com.banana.reservasalas.models.ValueObject;
import com.banana.reservasalas.repositories.AbstractGenericCrud;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractCrudResource<T extends ValueObject> {

    protected abstract AbstractGenericCrud<T> getRepository();

    @GET
    @Path("{id}")
    public T findById(@PathParam("id") Long id) {
        return getRepository().findById(id);
    }

    @GET
    public List<T> findAllOver() {
        return getRepository().findAll();
    }

    @POST
    public Response insert(T entity) {
        return Response.status(Response.Status.CREATED).entity(getRepository().insert(entity)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(T entity, @PathParam("id") Long id) {
        if (!id.equals(entity.getId())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("O registro não pode ser identificado").build();
        }
        return Response.status(Response.Status.OK).entity(getRepository().update(entity)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        getRepository().remove(id);
        return Response.status(Response.Status.OK).build();
    }


}
