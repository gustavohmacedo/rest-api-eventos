package com.gft.eventos.dto.tecnologia;

import com.gft.eventos.entities.Tecnologia;

public class TecnologiaMapper {

    public static Tecnologia fromDTO(RegistroTecnologiaDTO dto) {

        return new Tecnologia(null, dto.getNome(), dto.getDescricao());

    }

    public static ConsultaTecnologiaDTO fromEntity(Tecnologia tecnologia) {

        return new ConsultaTecnologiaDTO(tecnologia.getId(), tecnologia.getNome(), tecnologia.getDescricao());

    }
}
