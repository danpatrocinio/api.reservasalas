package com.banana.reservasalas.models.entidades;

import com.banana.reservasalas.models.ValueObject;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USUARIOS", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL", name = "email_uk"))
@SequenceGenerator(name = "USUARIOS_SEQ", sequenceName = "USUARIOS_SEQ", allocationSize = 1)
public class Usuarios implements ValueObject {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(generator = "USUARIOS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min = 2, max = 255, message = "{Usuarios.nome.Size}")
    @NotNull(message = "{Usuarios.nome.NotNull}")
    @Column(name = "NOME", length = 255)
    private String nome;

    @Email(message = "{Usuarios.email.Email}")
    @NotNull(message = "{Usuarios.email.NotNull}")
    @Size(max = 100, message = "{Usuarios.email.Size}")
    @Column(name = "EMAIL", length = 100)
    private String email;

    @Size(min = 8, max = 20, message = "{Usuarios.telefone.Size}")
    @Column(name = "TELEFONE", length = 255)
    private String telefone;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
