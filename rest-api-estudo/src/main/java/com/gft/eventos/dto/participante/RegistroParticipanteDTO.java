package com.gft.eventos.dto.participante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistroParticipanteDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String codigoDeReserva;

    private Long perfilId;

    private Long tecnologiaId;


}
