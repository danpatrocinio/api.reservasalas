package com.banana.reservasalas.models.entidades;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.banana.reservasalas.models.ValueObject;

@Entity
@Table(name = "RESERVAS")
@SequenceGenerator(name = "RESERVAS_SEQ", sequenceName = "RESERVAS_SEQ", allocationSize = 1)
public class Reservas implements ValueObject {

    @Id
    @Column(name = "ID_RESERVA")
    @GeneratedValue(generator = "RESERVAS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @NotNull(message = "{Reservas.sala.NotNull}")
    @JoinColumn(name = "ID_SALA", nullable = false)
    private Salas sala;

    @ManyToOne
    @NotNull(message = "{Reservas.usuario.NotNull}")
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuarios usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "{Reservas.dhInicio.NotNull}")
    @Column(name = "DH_INICIO", nullable = false)
    private Date dhInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "{Reservas.dhFinal.NotNull}")
    @Column(name = "DH_FINAL", nullable = false)
    private Date dhFinal;

    @Size(min = 2, max = 255, message = "{Reservas.observacao.Size}")
    @Column(name = "OBSERVACAO", length = 255)
    private String observacao;

    @Column(name = "CAFE", length = 1)
    private String cafe;

    @Column(name = "QTD_PESSOAS")
    private Integer qtdPessoas;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getDhInicio() {
        return dhInicio;
    }

    public void setDhInicio(Date dhInicio) {
        this.dhInicio = dhInicio;
    }

    public Date getDhFinal() {
        return dhFinal;
    }

    public void setDhFinal(Date dhFinal) {
        this.dhFinal = dhFinal;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public Integer getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(Integer qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
