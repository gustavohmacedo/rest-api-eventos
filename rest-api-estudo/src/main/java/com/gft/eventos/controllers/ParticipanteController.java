package com.gft.eventos.controllers;

import com.gft.eventos.dto.participante.ConsultaParticipanteDTO;
import com.gft.eventos.dto.participante.ParticipanteMapper;
import com.gft.eventos.dto.participante.RegistroParticipanteDTO;
import com.gft.eventos.entities.Participante;
import com.gft.eventos.services.ParticipanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("v1/participantes")
@Api(value="API REST Eventos")
@CrossOrigin(origins = "*")
public class ParticipanteController {

    private final ParticipanteService participanteService;


    @PostMapping
    @ApiOperation(value = "Salva um participante")
    public ResponseEntity<ConsultaParticipanteDTO> cadastraParticipante(@RequestBody @Valid RegistroParticipanteDTO dto) {

        Participante participante = participanteService.salvarParticipante(ParticipanteMapper.fromDTO(dto));

        return new ResponseEntity<>(ParticipanteMapper.fromEntity(participante), HttpStatus.CREATED);

    }


    @GetMapping
    @ApiOperation(value = "Retorna uma lista de participantes")
    public ResponseEntity<Page<ConsultaParticipanteDTO>> buscaParticipantes(@PageableDefault Pageable pageable) {

        return new ResponseEntity<>(participanteService.listarTodosParticipantes(pageable)
                .map(ParticipanteMapper::fromEntity), HttpStatus.OK);

    }

    @GetMapping("{id}")
    @ApiOperation(value = "Retorna um participante")
    public ResponseEntity<ConsultaParticipanteDTO> buscaParticipantePorId(@PathVariable Long id) {

        Participante participante = participanteService.listarUmParticipante(id);

        return new ResponseEntity<>(ParticipanteMapper.fromEntity(participante), HttpStatus.OK);

    }


    @PutMapping("{id}")
    @ApiOperation(value = "Atualiza um participante")
    public ResponseEntity<ConsultaParticipanteDTO> atualizaParticipante(@RequestBody @Valid RegistroParticipanteDTO dto,
                                                                        @PathVariable Long id) {

        Participante participante = participanteService.alterarParticipante(ParticipanteMapper.fromDTO(dto), id);

        return new ResponseEntity<>(ParticipanteMapper.fromEntity(participante), HttpStatus.OK);

    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "Apaga um participante")
    public ResponseEntity<?> excluiParticipante(@PathVariable Long id) {


        participanteService.excluirParticipante(id);

        return new ResponseEntity<>(HttpStatus.OK);


    }


}
