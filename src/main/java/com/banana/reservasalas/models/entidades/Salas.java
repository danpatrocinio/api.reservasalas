package com.banana.reservasalas.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.banana.reservasalas.models.ValueObject;

@Entity
@Table(name = "SALAS")
@SequenceGenerator(name = "SALAS_SEQ", sequenceName = "SALAS_SEQ", allocationSize = 1)
public class Salas implements ValueObject {

    @Id
    @Column(name = "ID_SALA")
    @GeneratedValue(generator = "SALAS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min = 2, max = 255, message = "{Salas.descricao.Size}")
    @NotNull(message = "{Salas.descricao.NotNull}")
    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    @NotNull(message = "{Salas.local.NotNull}")
    @ManyToOne
    @JoinColumn(name = "id")
    private Locais local;

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

    public Locais getLocal() {
        return local;
    }

    public void setLocal(Locais local) {
        this.local = local;
    }
}
