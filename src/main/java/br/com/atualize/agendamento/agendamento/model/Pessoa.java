package br.com.atualize.agendamento.agendamento.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PESSOAS")
public class Pessoa implements Serializable {
    @Id
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;
}
