package com.banana.reservasalas.rest;

import com.banana.reservasalas.models.entidades.Usuarios;
import com.banana.reservasalas.repositories.BusinessException;
import com.banana.reservasalas.repositories.UsuariosRepository;
import io.jsonwebtoken.Jwts;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.banana.reservasalas.filters.AuthFilter.AUTHORIZATION_KEY;
import static com.banana.reservasalas.filters.AuthFilter.LOGIN_PATH;

@Path("logar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorizationResource {

    @Inject
    UsuariosRepository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@Context HttpServletRequest req) {
        return Response.ok(req.getScheme()
                .concat("://")
                .concat(req.getServerName())
                .concat(":")
                .concat(String.valueOf(req.getServerPort()))
                .concat(LOGIN_PATH))
                .status(Response.Status.FORBIDDEN)
                .build();
    }

    @POST
    public Response logar(Usuarios usuario) {

        if (usuario == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            throw new BusinessException("Informe o email e senha do usuário");
        }

        Usuarios usuarioCadastrado = repository.findByEmail(usuario.getEmail());
        if (usuarioCadastrado == null || !usuarioCadastrado.getSenha().equals(usuario.getSenha())) {
            throw new BusinessException("Usuário ou senha não cadastrados");
        }

        return Response
                .ok(new Authorization(Jwts
                        .builder()
                        .setSubject(usuarioCadastrado.getEmail())
                        .setId(usuarioCadastrado.getId().toString())
                        .signWith(AUTHORIZATION_KEY).compact()))
                .build();
    }

    private class Authorization {
        private String token;
        Authorization(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }
    }

}
