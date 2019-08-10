package br.com.atualize.agendamento.agendamento.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "SERVICOS")
public class Servico implements Serializable {
    @Id
    @Column(name = "ID_SERVICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
}
