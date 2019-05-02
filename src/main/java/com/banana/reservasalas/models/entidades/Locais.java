package com.banana.reservasalas.models.entidades;

import com.banana.reservasalas.models.ValueObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LOCAIS")
@SequenceGenerator(name = "LOCAIS_SEQ", sequenceName = "LOCAIS_SEQ", allocationSize = 1)
public class Locais implements ValueObject {

    @Id
    @Column(name = "ID_LOCAL")
    @GeneratedValue(generator = "LOCAIS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min = 2, max = 255, message = "{Locais.descricao.Size}")
    @NotNull(message = "{Locais.descricao.NotNull}")
    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    @Size(min = 2, max = 255, message = "{Locais.endereco.Size}")
    @Column(name = "ENDERECO", length = 255)
    private String endereco;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
