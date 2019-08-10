package br.com.atualize.agendamento.agendamento.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AGENDAS")
public class Agenda implements Serializable {

    @Id
    @Column(name = "ID_AGENDA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PROFISSIONAL")
    private Profissional profissional;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_SERVICO")
    private Servico servico;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
}
