package com.gft.eventos.dto.participante;

import com.gft.eventos.entities.Participante;
import com.gft.eventos.entities.Perfil;
import com.gft.eventos.entities.Tecnologia;

public class ParticipanteMapper {

    public static Participante fromDTO(RegistroParticipanteDTO dto) {

        Perfil perfil = new Perfil();
        perfil.setId(dto.getPerfilId());

        Tecnologia tecnologia = new Tecnologia();
        tecnologia.setId(dto.getTecnologiaId());

        return new Participante(null, dto.getNome(), dto.getCodigoDeReserva(), perfil, tecnologia);

    }

    public static ConsultaParticipanteDTO fromEntity(Participante participante) {

        return new ConsultaParticipanteDTO(participante.getId(), participante.getNome(),
                participante.getCodigoDeReserva(), participante.getPerfil(), participante.getTecnologia());

    }


}
