package com.gft.eventos.dto.evento;

import com.gft.eventos.entities.Participante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistroEventoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String local;

    @NotBlank
    private String data;

    @NotBlank
    private String horario;

    private List<Participante> participantes;

}