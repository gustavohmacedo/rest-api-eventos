package com.gft.eventos.dto.evento;

import com.gft.eventos.entities.Evento;

public class EventoMapper {
    public static Evento fromDTO(RegistroEventoDTO dto) {

        return new Evento(null, dto.getNome(), dto.getLocal(), dto.getData(), dto.getHorario(),
                (dto.getParticipantes()));

    }

    public static ConsultaEventoDTO fromEntity(Evento evento) {

        return new ConsultaEventoDTO(evento.getId(), evento.getNome(), evento.getLocal(),
                evento.getData(), evento.getHorario(), evento.getParticipantes());

    }

}


