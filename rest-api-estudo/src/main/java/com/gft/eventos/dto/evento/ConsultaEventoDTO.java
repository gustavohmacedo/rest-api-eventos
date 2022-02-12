package com.gft.eventos.dto.evento;

import com.gft.eventos.entities.Participante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ConsultaEventoDTO {
    private Long id;

    private String nome;

    private String local;

    private String data;

    private String horario;

    private List<Participante> participantes;


}
