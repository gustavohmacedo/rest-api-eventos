package com.gft.eventos.dto.participante;

import com.gft.eventos.entities.Perfil;
import com.gft.eventos.entities.Tecnologia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ConsultaParticipanteDTO {

    private Long id;

    private String nome;

    private String codigoDeReserva;

    private Perfil perfil;

    private Tecnologia tecnologia;


}
