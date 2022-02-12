package com.gft.eventos.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "tb_participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter private Long id;

    @Setter @Getter private String nome;

    @Setter @Getter private String codigoDeReserva;

    @ManyToOne
    @Setter @Getter private Perfil perfil;

    @ManyToOne
    @Setter @Getter private Tecnologia tecnologia;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Participante(Long id, String nome, String codigoDeReserva, Perfil perfil, Tecnologia tecnologia) {
        this.id = id;
        this.nome = nome;
        this.codigoDeReserva = codigoDeReserva;
        this.perfil = perfil;
        this.tecnologia = tecnologia;
    }
}
