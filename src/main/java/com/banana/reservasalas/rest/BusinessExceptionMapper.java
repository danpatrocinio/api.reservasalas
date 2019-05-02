package com.banana.reservasalas.rest;

import com.banana.reservasalas.repositories.BusinessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\" : \"".concat(e.getMessage().concat("\"}"))).build();
    }

}
