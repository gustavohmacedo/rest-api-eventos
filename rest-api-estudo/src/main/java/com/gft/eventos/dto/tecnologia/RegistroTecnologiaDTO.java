package com.gft.eventos.dto.tecnologia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistroTecnologiaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;


}
